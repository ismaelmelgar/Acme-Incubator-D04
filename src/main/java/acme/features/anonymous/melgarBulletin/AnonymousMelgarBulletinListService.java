
package acme.features.anonymous.melgarBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.MelgarBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousMelgarBulletinListService implements AbstractListService<Anonymous, MelgarBulletin> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AnonymousMelgarBulletinRepository repository;

	// AbstractListService<Administrator, MelgarBulletin> interface ------------------------------


	@Override
	public boolean authorise(final Request<MelgarBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<MelgarBulletin> findMany(final Request<MelgarBulletin> request) {
		assert request != null;

		Collection<MelgarBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<MelgarBulletin> request, final MelgarBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "moment");
	}
}
