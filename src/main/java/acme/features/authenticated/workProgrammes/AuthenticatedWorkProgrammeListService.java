
package acme.features.authenticated.workProgrammes;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedWorkProgrammeListService implements AbstractListService<Authenticated, WorkProgramme> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AuthenticatedWorkProgrammeRepository repository;

	// AbstractListService<Authenticated, WorkProgramme> interface ------------------------------


	@Override
	public boolean authorise(final Request<WorkProgramme> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<WorkProgramme> findMany(final Request<WorkProgramme> request) {
		assert request != null;

		Collection<WorkProgramme> result;
		int investmentRoundId = request.getModel().getInteger("investmenRoundId");
		result = this.repository.findWorkProgrammeByInvestmentRoundId(investmentRoundId);

		return result;
	}

	@Override
	public void unbind(final Request<WorkProgramme> request, final WorkProgramme entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "budget");

	}
}
