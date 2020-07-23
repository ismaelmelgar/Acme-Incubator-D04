
package acme.features.anonymous.melgarBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.MelgarBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousMelgarBulletinCreateService implements AbstractCreateService<Anonymous, MelgarBulletin> {

	// Internal state -------------------------------------------------------------------

	@Autowired
	AnonymousMelgarBulletinRepository repository;


	@Override
	public boolean authorise(final Request<MelgarBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public MelgarBulletin instantiate(final Request<MelgarBulletin> request) {
		assert request != null;

		MelgarBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new MelgarBulletin();
		result.setAuthor("Pepe Matega");
		result.setText("Hey!");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<MelgarBulletin> request, final MelgarBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text");

	}

	@Override
	public void bind(final Request<MelgarBulletin> request, final MelgarBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<MelgarBulletin> request, final MelgarBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<MelgarBulletin> request, final MelgarBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
