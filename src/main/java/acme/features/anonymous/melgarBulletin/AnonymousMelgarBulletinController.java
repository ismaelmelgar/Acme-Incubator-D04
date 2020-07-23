
package acme.features.anonymous.melgarBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.MelgarBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/melgarBulletin/")
public class AnonymousMelgarBulletinController extends AbstractController<Anonymous, MelgarBulletin> {

	// Internal state ------------------------------------------------

	@Autowired
	private AnonymousMelgarBulletinListService		listService;

	@Autowired
	private AnonymousMelgarBulletinCreateService	createService;

	// Constructors --------------------------------------------------


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
