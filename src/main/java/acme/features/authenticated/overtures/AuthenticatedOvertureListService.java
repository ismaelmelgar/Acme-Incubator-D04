
package acme.features.authenticated.overtures;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.overtures.Overture;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedOvertureListService implements AbstractListService<Authenticated, Overture> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AuthenticatedOvertureRepository repository;


	// AbstractListService<Authenticated, Overture> interface ------------------------------
	@Override
	public boolean authorise(final Request<Overture> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Overture> request, final Overture entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description");

	}

	@Override
	public Collection<Overture> findMany(final Request<Overture> request) {
		assert request != null;

		Collection<Overture> result;

		Calendar cal = new GregorianCalendar();
		Date time = cal.getTime();

		result = this.repository.findMany(time);

		return result;
	}
}
