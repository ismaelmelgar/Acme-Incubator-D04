
package acme.features.authenticated.inquirie;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.inquiries.Inquirie;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/inquirie/")
public class AuthenticatedInquirieController extends AbstractController<Authenticated, Inquirie> {

	// Internal state ------------------------------------------------
	@Autowired
	private AuthenticatedInquirieListService	listService;

	@Autowired
	private AuthenticatedInquirieShowService	showService;


	// Constructors --------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
