
package acme.features.authenticated.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forums.Forum;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedForumShowService implements AbstractShowService<Authenticated, Forum> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	AuthenticatedForumRepository repository;


	// AbstractListService<Authenticated, Forum> interface ------------------------------
	@Override
	public boolean authorise(final Request<Forum> request) {
		assert request != null;
		boolean result;

		int forumId;
		Forum forum;
		int principalId;
		int fAuId;

		forumId = request.getModel().getInteger("id");
		forum = this.repository.findOneById(forumId);
		fAuId = forum.getAuthenticated().getUserAccount().getId();
		principalId = request.getPrincipal().getAccountId();
		result = fAuId == principalId;

		return result;
	}

	@Override
	public void unbind(final Request<Forum> request, final Forum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "investmentRound.ticker");
	}

	@Override
	public Forum findOne(final Request<Forum> request) {
		assert request != null;

		Forum result;
		int id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
