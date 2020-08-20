
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forums.Forum;
import acme.entities.messages.Message;
import acme.features.authenticated.forum.AuthenticatedForumRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListMineService implements AbstractListService<Authenticated, Message> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	AuthenticatedMessageRepository	repository;

	AuthenticatedForumRepository	forumRepository;


	// AbstractListService<Authenticated, Message> interface ------------------------------
	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		boolean result;

		int forumId;
		Forum forum;
		int principalId;
		int fAuId;

		forumId = request.getModel().getInteger("forumid");
		forum = this.repository.findByForumId(forumId);
		fAuId = forum.getAuthenticated().getUserAccount().getId();
		principalId = request.getPrincipal().getAccountId();
		result = fAuId == principalId;

		return result;
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
