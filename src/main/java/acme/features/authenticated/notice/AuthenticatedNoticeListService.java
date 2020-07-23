
package acme.features.authenticated.notice;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.notices.Notice;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedNoticeListService implements AbstractListService<Authenticated, Notice> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AuthenticatedNoticeRepository repository;


	// AbstractListService<Authenticated, Notice> interface ------------------------------
	@Override
	public boolean authorise(final Request<Notice> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Notice> request, final Notice entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creation", "deadline", "title");
	}

	@Override
	public Collection<Notice> findMany(final Request<Notice> request) {
		assert request != null;

		Collection<Notice> result;

		Calendar cal = new GregorianCalendar();
		Date time = cal.getTime();

		result = this.repository.findManyByTime(time);

		return result;
	}

}
