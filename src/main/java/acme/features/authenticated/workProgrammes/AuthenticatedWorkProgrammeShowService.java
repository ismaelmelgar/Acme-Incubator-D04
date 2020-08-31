
package acme.features.authenticated.workProgrammes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.workProgrammes.WorkProgramme;
import acme.features.authenticated.investmentRounds.AuthenticatedInvestmentRoundRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedWorkProgrammeShowService implements AbstractShowService<Authenticated, WorkProgramme> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AuthenticatedWorkProgrammeRepository	repository;

	@Autowired
	AuthenticatedInvestmentRoundRepository	investmentRoundRepository;


	// AbstractListService<Authenticated, WorkProgramme> interface ------------------------------

	@Override
	public boolean authorise(final Request<WorkProgramme> request) {
		assert request != null;

		boolean result = true;
		int workProgrammeId;
		InvestmentRound investmentRound;
		workProgrammeId = request.getModel().getInteger("id");
		investmentRound = this.repository.findInvestmentRoundByWorkProgrammeId(workProgrammeId);

		// If the investment round is not already published you can not see their work programmes
		if (investmentRound.getStatus() == false) {
			result = false;
		}

		return result;
	}
	@Override
	public void unbind(final Request<WorkProgramme> request, final WorkProgramme entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "start", "end", "budget");

	}

	@Override
	public WorkProgramme findOne(final Request<WorkProgramme> request) {
		assert request != null;

		WorkProgramme result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
