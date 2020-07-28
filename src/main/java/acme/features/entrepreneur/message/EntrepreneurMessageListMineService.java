
package acme.features.entrepreneur.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EntrepreneurMessageListMineService implements AbstractListService<Entrepreneur, Message> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	EntrepreneurMessageRepository repository;


	// AbstractListService<Entrepreneur, Message> interface ------------------------------
	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creation");

	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {
		assert request != null;

		Collection<Message> result;
		int forumId = request.getModel().getInteger("forumid");

		result = this.repository.findMany(forumId);

		return result;
	}
}
