
package acme.features.authenticated.investmentRounds;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedInvestmentRoundListService implements AbstractListService<Authenticated, InvestmentRound> {

	// Internal state ------------------------------------------------------------------
	@Autowired
	AuthenticatedInvestmentRoundRepository repository;

	// AbstractListService<Authenticated, InvestmentRound> interface ------------------------------


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<InvestmentRound> findMany(final Request<InvestmentRound> request) {
		assert request != null;

		Collection<InvestmentRound> result;
		result = this.repository.findInvestmentRoundActives();

		return result;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "entrepreneur.identity.fullName");
	}
}
