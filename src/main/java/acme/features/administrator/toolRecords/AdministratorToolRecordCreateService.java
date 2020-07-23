
package acme.features.administrator.toolRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolRecords.ToolRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorToolRecordCreateService implements AbstractCreateService<Administrator, ToolRecord> {

	// Internal state ------------------------------------------------
	@Autowired
	AdministratorToolRecordRepository repository;


	// AbstractCreateService<Administrator, ToolRecord> interface ------------------------------
	@Override
	public boolean authorise(final Request<ToolRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<ToolRecord> request, final ToolRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<ToolRecord> request, final ToolRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventor", "description", "web", "email", "sourceType", "stars");

	}

	@Override
	public ToolRecord instantiate(final Request<ToolRecord> request) {
		ToolRecord result;

		result = new ToolRecord();

		return result;
	}

	@Override
	public void validate(final Request<ToolRecord> request, final ToolRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ToolRecord> request, final ToolRecord entity) {

		this.repository.save(entity);

	}

}
