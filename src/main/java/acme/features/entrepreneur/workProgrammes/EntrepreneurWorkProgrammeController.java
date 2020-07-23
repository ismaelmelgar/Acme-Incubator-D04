
package acme.features.entrepreneur.workProgrammes;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Entrepreneur;
import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/work-programme/")
public class EntrepreneurWorkProgrammeController extends AbstractController<Entrepreneur, WorkProgramme> {

	// Internal state ------------------------------------------------

	@Autowired
	private EntrepreneurWorkProgrammeListService	listService;

	@Autowired
	private EntrepreneurWorkProgrammeShowService		showService;


	// Constructors --------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
