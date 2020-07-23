
package acme.features.anonymous.notices;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.notices.Notice;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousNoticeRepository extends AbstractRepository {

	@Query("select n from Notice n where n.id = ?1")
	Notice findOneById(int id);

	@Query("select n from Notice n where n.deadline > ?1")
	Collection<Notice> findManyByTime(Date time);

}
