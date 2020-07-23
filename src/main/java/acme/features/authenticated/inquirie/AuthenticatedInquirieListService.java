
package acme.features.authenticated.inquirie;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiries.Inquirie;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedInquirieListService implements AbstractListService<Authenticated, Inquirie> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AuthenticatedInquirieRepository repository;


	// AbstractListService<Authenticated, Inquirie> interface ------------------------------
	@Override
	public boolean authorise(final Request<Inquirie> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Inquirie> request, final Inquirie entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "deadline");
	}

	@Override
	public Collection<Inquirie> findMany(final Request<Inquirie> request) {
		assert request != null;

		Calendar c;
		c = new GregorianCalendar();
		c.add(Calendar.MONTH, 0);
		Date d = c.getTime();

		Collection<Inquirie> result;
		result = this.repository.findMany(d);

		return result;
	}

}
