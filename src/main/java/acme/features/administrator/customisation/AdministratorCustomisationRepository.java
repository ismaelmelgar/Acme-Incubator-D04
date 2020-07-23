
package acme.features.administrator.customisation;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Customisation;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorCustomisationRepository extends AbstractRepository {

	@Query("select c from Customisation c")
	Collection<Customisation> findMany();

	@Query("select c from Customisation c where c.id = ?1")
	Customisation findOneById(int id);
}
