
package acme.features.administrator.inquirie;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.inquiries.Inquirie;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInquirieRepository extends AbstractRepository {

	@Query("select i from Inquirie i where i.deadline > ?1")
	Collection<Inquirie> findMany(Date d);

	@Query("select i from Inquirie i where i.id = ?1")
	Inquirie findOneById(int id);

}
