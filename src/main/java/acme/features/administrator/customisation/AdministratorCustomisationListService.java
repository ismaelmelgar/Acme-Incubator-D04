
package acme.features.administrator.customisation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.Customisation;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorCustomisationListService implements AbstractListService<Administrator, Customisation> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AdministratorCustomisationRepository repository;

	// AbstractListService<Anonymous, TechnologyRecord> interface ------------------------------


	@Override
	public boolean authorise(final Request<Customisation> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Customisation> findMany(final Request<Customisation> request) {
		assert request != null;

		Collection<Customisation> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<Customisation> request, final Customisation entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spamWords", "threshold", "activitySectors");
	}
}
