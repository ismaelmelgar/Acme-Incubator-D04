
package acme.features.administrator.inquirie;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiries.Inquirie;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorInquirieUpdateService implements AbstractUpdateService<Administrator, Inquirie> {

	// Internal state ------------------------------------------------

	@Autowired
	AdministratorInquirieRepository repository;


	// AbstractUpdateService<Administrator, Inquirie> interface ------------------------------

	@Override
	public boolean authorise(final Request<Inquirie> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Inquirie> request, final Inquirie entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Inquirie> request, final Inquirie entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "minMoney", "maxMoney", "email");
	}

	@Override
	public Inquirie findOne(final Request<Inquirie> request) {
		assert request != null;

		Inquirie result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Inquirie> request, final Inquirie entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean isDeadlineNotVeryClose, isMinMoneyLessMaxMoney, isMaxMoneyHigherMinMoney;

		if (!errors.hasErrors("deadline")) {
			Calendar c = new GregorianCalendar();
			c.add(Calendar.MONTH, 1);
			Date minDeadline = c.getTime();
			isDeadlineNotVeryClose = entity.getDeadline().after(minDeadline);
			errors.state(request, isDeadlineNotVeryClose, "deadline", "administrator.inquirie.error.deadline.veryClose");
		}

		if (!errors.hasErrors("minMoney")) {
			isMinMoneyLessMaxMoney = entity.getMinMoney().getAmount() < entity.getMaxMoney().getAmount();
			errors.state(request, isMinMoneyLessMaxMoney, "minMoney", "administrator.inquirie.error.minMoney.LessMaxMoney");
		}

		if (!errors.hasErrors("maxMoney")) {
			isMaxMoneyHigherMinMoney = entity.getMaxMoney().getAmount() > entity.getMinMoney().getAmount();
			errors.state(request, isMaxMoneyHigherMinMoney, "maxMoney", "administrator.inquirie.error.maxMoney.HigherMinMoney");
		}

	}

	@Override
	public void update(final Request<Inquirie> request, final Inquirie entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);
		this.repository.save(entity);
	}
}
