
package acme.features.investor.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forums.Forum;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorForumShowService implements AbstractShowService<Investor, Forum> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	InvestorForumRepository repository;


	// AbstractListService<Investor, Forum> interface ------------------------------
	@Override
	public boolean authorise(final Request<Forum> request) {
		assert request != null;

		int forumId;
		Forum forum;
		InvestmentRound investmentRound;
		Principal principal;

		forumId = request.getModel().getInteger("id");
		forum = this.repository.findOneById(forumId);
		investmentRound = forum.getInvestmentRound();
		principal = request.getPrincipal();

		return !this.repository.findInvestmentRound(principal.getActiveRoleId(), investmentRound.getId()).isEmpty();
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
