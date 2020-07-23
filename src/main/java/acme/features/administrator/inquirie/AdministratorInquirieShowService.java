
package acme.features.administrator.inquirie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiries.Inquirie;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorInquirieShowService implements AbstractShowService<Administrator, Inquirie> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AdministratorInquirieRepository repository;


	// AbstractListService<Administrator, Inquirie> interface ------------------------------
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

		request.unbind(entity, model, "title", "creationMoment", "deadline", "description", "minMoney", "maxMoney", "email");

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

}
