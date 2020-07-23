
package acme.features.authenticated.workProgrammes;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/work-programme/")
public class AuthenticatedWorkProgrammeController extends AbstractController<Authenticated, WorkProgramme> {

	// Internal state ------------------------------------------------

	@Autowired
	private AuthenticatedWorkProgrammeListService	listService;

	@Autowired
	private AuthenticatedWorkProgrammeShowService	showService;


	// Constructors --------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
