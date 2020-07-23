
package acme.features.administrator.notice;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.notices.Notice;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorNoticeCreateService implements AbstractCreateService<Administrator, Notice> {

	// Internal state -------------------------------------------------------------------

	@Autowired
	AdministratorNoticeRepository repository;


	// AbstractCreateService<Administrator, Notice> interface ------------------------------
	@Override
	public boolean authorise(final Request<Notice> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Notice> request, final Notice entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "header", "title", "creation", "deadline", "body", "link", "finalMode");

	}

	@Override
	public Notice instantiate(final Request<Notice> request) {
		assert request != null;
		Notice result = new Notice();

		Date date;

		date = new Date(System.currentTimeMillis() - 1);
		result.setCreation(date);

		return result;
	}

	@Override
	public void validate(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Calendar calendar = new GregorianCalendar();
			Date currentMoment = calendar.getTime();
			errors.state(request, request.getModel().getDate("deadline").after(currentMoment), "deadline", "administrator.notice.error.deadline");
		}

	}

	@Override
	public void create(final Request<Notice> request, final Notice entity) {
		assert request != null;
		assert entity != null;

		Date date;

		date = new Date(System.currentTimeMillis() - 1);
		entity.setCreation(date);
		this.repository.save(entity);

	}

}
