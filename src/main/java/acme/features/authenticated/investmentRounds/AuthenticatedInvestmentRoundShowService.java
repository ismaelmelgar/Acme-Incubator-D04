
package acme.features.authenticated.investmentRounds;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedInvestmentRoundShowService implements AbstractShowService<Authenticated, InvestmentRound> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AuthenticatedInvestmentRoundRepository repository;

	// AbstractListService<Authenticated, InvestmentRound> interface ------------------------------


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		boolean result = true;
		Integer investmentRoundId;
		InvestmentRound investmentRound;

		investmentRoundId = request.getModel().getInteger("id");
		investmentRound = this.repository.findOneById(investmentRoundId);

		if (investmentRound.getStatus() == false) {
			result = false;
		}

		return result;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int id = request.getModel().getInteger("id");
		int numAR = this.repository.findAccountingRecordByInvestmentRoundId(id);
		model.setAttribute("numAR", numAR);

		request.unbind(entity, model, "ticker", "creationMoment", "round", "title", "description", "amountMoney", "moreInfo", "entrepreneur.identity.fullName", "status");

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
