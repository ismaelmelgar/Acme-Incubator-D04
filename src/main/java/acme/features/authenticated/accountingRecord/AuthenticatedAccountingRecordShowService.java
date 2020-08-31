
package acme.features.authenticated.accountingRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecords.AccountingRecord;
import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAccountingRecordShowService implements AbstractShowService<Authenticated, AccountingRecord> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	AuthenticatedAccountingRecordRepository repository;


	// AbstractListService<Authenticated, AccountingRecord> interface ------------------------------
	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;

		boolean result = true;
		int accountingRecordId;
		InvestmentRound investmentRound;
		accountingRecordId = request.getModel().getInteger("id");
		investmentRound = this.repository.findInvestmentRoundByAccountingRecordId(accountingRecordId);

		// If the investment round is not already published you can not see their accounting records
		if (investmentRound.getStatus() == false) {
			result = false;
		}

		return result;
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "status", "creation", "body", "bookkeeper.identity.fullName", "investmentRound.ticker");
	}

	@Override
	public AccountingRecord findOne(final Request<AccountingRecord> request) {
		assert request != null;

		AccountingRecord result;
		int id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
