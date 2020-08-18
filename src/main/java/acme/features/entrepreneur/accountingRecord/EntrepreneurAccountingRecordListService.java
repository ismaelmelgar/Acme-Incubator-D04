
package acme.features.entrepreneur.accountingRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecords.AccountingRecord;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EntrepreneurAccountingRecordListService implements AbstractListService<Entrepreneur, AccountingRecord> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	EntrepreneurAccountingRecordRepository repository;


	// AbstractListService<Entrepreneur, AccountingRecord> interface ------------------------------
	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creation");

	}

	@Override
	public Collection<AccountingRecord> findMany(final Request<AccountingRecord> request) {
		assert request != null;

		Collection<AccountingRecord> result;
		int investmentRoundId = request.getModel().getInteger("investmentRoundid");
		result = this.repository.findManyByInvestmentRoundId(investmentRoundId);

		return result;
	}
}
