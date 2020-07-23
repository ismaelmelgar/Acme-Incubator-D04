
package acme.features.administrator.notice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.notices.Notice;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorNoticeListService implements AbstractListService<Administrator, Notice> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AdministratorNoticeRepository repository;


	// AbstractListService<Administrator, Notice> interface ------------------------------
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

		result = this.repository.findMany();

		return result;
	}

}
