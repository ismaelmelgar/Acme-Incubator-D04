
package acme.features.administrator.overtures;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.overtures.Overture;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorOvertureUpdateService implements AbstractUpdateService<Administrator, Overture> {

	@Autowired
	AdministratorOvertureRepository repository;


	@Override
	public boolean authorise(final Request<Overture> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Overture> request, final Overture entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Overture> request, final Overture entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "creation", "deadline", "maxMoney", "minMoney", "email");

	}

	@Override
	public Overture findOne(final Request<Overture> request) {
		assert request != null;

		Overture result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Overture> request, final Overture entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Calendar calendar = new GregorianCalendar();
			Date currentMoment = calendar.getTime();
			errors.state(request, request.getModel().getDate("deadline").after(currentMoment), "deadline", "administrator.overture.error.deadline");
		}
		if (!errors.hasErrors("maxMoney")) {
			errors.state(request, entity.getMaxMoney().getCurrency().equals("EUR") || entity.getMaxMoney().getCurrency().equals("€"), "maxMoney", "administrator.overture.form.error.format");
		}
		if (!errors.hasErrors("minMoney")) {
			errors.state(request, entity.getMinMoney().getCurrency().equals("EUR") || entity.getMinMoney().getCurrency().equals("€"), "minMoney", "administrator.overture.form.error.format");
			errors.state(request, entity.getMaxMoney().getAmount() > entity.getMinMoney().getAmount(), "maxMoney", "administrator.overture.form.error.max");
		}

	}

	@Override
	public void update(final Request<Overture> request, final Overture entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
