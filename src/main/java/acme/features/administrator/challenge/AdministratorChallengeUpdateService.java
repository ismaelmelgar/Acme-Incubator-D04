
package acme.features.administrator.challenge;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

	// Internal state ------------------------------------------------

	@Autowired
	AdministratorChallengeRepository repository;


	// AbstractUpdateService<Administrator, Challenge> interface ------------------------------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "minMoney", "maxMoney", "email");
	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;

		Challenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isDeadlineNotVeryClose, isRookieRewardEuro, isAverageRewardEuro, isExpertRewardEuro, isRookieMinusThanAverageExpert, isAveragePlusThanRookieMinusThanExpert, isExpertPlusThanRookieAverage;

		if (!errors.hasErrors("deadline")) {
			Calendar c = new GregorianCalendar();
			c.add(Calendar.MONTH, 1);
			Date minDeadline = c.getTime();
			isDeadlineNotVeryClose = entity.getDeadline().after(minDeadline);
			errors.state(request, isDeadlineNotVeryClose, "deadline", "administrator.challenge.error.deadline.veryClose");
		}

		if (!errors.hasErrors("rookieReward")) {
			String rookieCurrency = entity.getRookieReward().getCurrency();
			isRookieRewardEuro = rookieCurrency.equals("€") || rookieCurrency.equals("EUR");
			errors.state(request, isRookieRewardEuro, "rookieReward", "administrator.challenge.error.reward.euro");

			Double rookieAmount = entity.getRookieReward().getAmount();
			isRookieMinusThanAverageExpert = rookieAmount < entity.getAverageReward().getAmount() && rookieAmount < entity.getExpertReward().getAmount();
			errors.state(request, isRookieMinusThanAverageExpert, "rookieReward", "administrator.challenge.error.rookieReward.amount");
		}

		if (!errors.hasErrors("averageReward")) {
			String averageCurrency = entity.getAverageReward().getCurrency();
			isAverageRewardEuro = averageCurrency.equals("€") || averageCurrency.equals("EUR");
			errors.state(request, isAverageRewardEuro, "averageReward", "administrator.challenge.error.reward.euro");

			Double averageAmount = entity.getAverageReward().getAmount();
			isAveragePlusThanRookieMinusThanExpert = averageAmount > entity.getRookieReward().getAmount() && averageAmount < entity.getExpertReward().getAmount();
			errors.state(request, isAveragePlusThanRookieMinusThanExpert, "averageReward", "administrator.challenge.error.averageReward.amount");
		}

		if (!errors.hasErrors("expertReward")) {
			String expertCurrency = entity.getExpertReward().getCurrency();
			isExpertRewardEuro = expertCurrency.equals("€") || expertCurrency.equals("EUR");
			errors.state(request, isExpertRewardEuro, "expertReward", "administrator.challenge.error.reward.euro");

			Double expertAmount = entity.getExpertReward().getAmount();
			isExpertPlusThanRookieAverage = expertAmount > entity.getRookieReward().getAmount() && expertAmount > entity.getAverageReward().getAmount();
			errors.state(request, isExpertPlusThanRookieAverage, "expertReward", "administrator.challenge.error.expertReward.amount");
		}

	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
}
