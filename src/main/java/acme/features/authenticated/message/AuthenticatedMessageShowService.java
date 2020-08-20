
package acme.features.authenticated.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageShowService implements AbstractShowService<Authenticated, Message> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	AuthenticatedMessageRepository repository;


	// AbstractListService<Authenticated, Message> interface ------------------------------
	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		boolean result;

		int messageId;
		Message message;
		int principalId;
		int mAuId;

		messageId = request.getModel().getInteger("id");
		message = this.repository.findOneById(messageId);
		mAuId = message.getForum().getAuthenticated().getUserAccount().getId();
		principalId = request.getPrincipal().getAccountId();
		result = mAuId == principalId;

		return result;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creation", "tags", "body");

	}

	@Override
	public Message findOne(final Request<Message> request) {
		assert request != null;

		Message result;
		int id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
