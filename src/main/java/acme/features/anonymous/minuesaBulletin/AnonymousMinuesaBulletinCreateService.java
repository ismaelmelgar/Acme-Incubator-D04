
package acme.features.anonymous.minuesaBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.MinuesaBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousMinuesaBulletinCreateService implements AbstractCreateService<Anonymous, MinuesaBulletin> {

	// Internal state -------------------------------------------------------------------

	@Autowired
	AnonymousMinuesaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<MinuesaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public MinuesaBulletin instantiate(final Request<MinuesaBulletin> request) {
		assert request != null;

		MinuesaBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new MinuesaBulletin();
		result.setAuthor("Thor Menta");
		result.setText("¡Por Odin!");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<MinuesaBulletin> request, final MinuesaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text");

	}

	@Override
	public void bind(final Request<MinuesaBulletin> request, final MinuesaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<MinuesaBulletin> request, final MinuesaBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<MinuesaBulletin> request, final MinuesaBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
