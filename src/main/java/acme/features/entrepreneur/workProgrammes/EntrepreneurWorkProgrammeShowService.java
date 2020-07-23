
package acme.features.entrepreneur.workProgrammes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Entrepreneur;
import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurWorkProgrammeShowService implements AbstractShowService<Entrepreneur, WorkProgramme> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	EntrepreneurWorkProgrammeRepository repository;

	// AbstractListService<Entrepreneur, WorkProgramme> interface ------------------------------


	@Override
	public boolean authorise(final Request<WorkProgramme> request) {
		assert request != null;

		boolean result;
		int workProgrammeId;
		WorkProgramme workProgramme;
		Entrepreneur entrepreneur;
		Principal principal;

		workProgrammeId = request.getModel().getInteger("id");
		workProgramme = this.repository.findOneById(workProgrammeId);
		entrepreneur = workProgramme.getInvestmentRound().getEntrepreneur();
		principal = request.getPrincipal();
		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

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
