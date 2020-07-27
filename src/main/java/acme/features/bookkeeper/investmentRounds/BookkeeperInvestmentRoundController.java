
package acme.features.bookkeeper.investmentRounds;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("bookkeeper/investment-round")
public class BookkeeperInvestmentRoundController extends AbstractController<Bookkeeper, InvestmentRound> {

	// Internal state ------------------------------------------------

	@Autowired
	private BookkeeperInvestmentRoundListMineService	listMineService;

	@Autowired
	private BookkeeperInvestmentRoundShowService		showService;


	// Constructors --------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}
}
