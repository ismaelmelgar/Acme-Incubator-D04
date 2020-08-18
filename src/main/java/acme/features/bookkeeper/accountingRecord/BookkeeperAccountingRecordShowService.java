
package acme.features.bookkeeper.accountingRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecords.AccountingRecord;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class BookkeeperAccountingRecordShowService implements AbstractShowService<Bookkeeper, AccountingRecord> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	BookkeeperAccountingRecordRepository repository;


	// AbstractListService<Bookkeeper, AccountingRecord> interface ------------------------------
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
