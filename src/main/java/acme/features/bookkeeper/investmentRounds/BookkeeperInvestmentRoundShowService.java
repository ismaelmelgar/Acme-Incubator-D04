
package acme.features.bookkeeper.investmentRounds;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class BookkeeperInvestmentRoundShowService implements AbstractShowService<Bookkeeper, InvestmentRound> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	BookkeeperInvestmentRoundRepository repository;


	// AbstractListService<Bookkeeper, InvestmentRound> interface ------------------------------
	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationMoment", "round", "title", "description", "amountMoney", "moreInfo", "entrepreneur.identity.fullName");

	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		//Money of the Work Programmes + Money of the Investment Rounds

		Double contador = 0.;
		contador = contador + result.getAmountMoney().getAmount();
		Collection<WorkProgramme> res = this.repository.findWorkProgrammeByInvestmentRoundId(id);
		for (WorkProgramme wp : res) {
			contador = contador + wp.getBudget().getAmount();
		}
		result.getAmountMoney().setAmount(contador);

		return result;
	}

}
