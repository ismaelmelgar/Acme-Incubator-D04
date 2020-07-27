
package acme.features.investor.forum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forums.Forum;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class InvestorForumListMineService implements AbstractListService<Investor, Forum> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	InvestorForumRepository repository;


	// AbstractListService<Investor, Forum> interface ------------------------------
	@Override
	public boolean authorise(final Request<Forum> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Forum> request, final Forum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "investmentRound.ticker");

	}

	@Override
	public Collection<Forum> findMany(final Request<Forum> request) {
		assert request != null;

		Collection<Forum> result;
		Principal principal = request.getPrincipal();

		result = this.repository.findMany(principal.getActiveRoleId());

		return result;
	}
}
