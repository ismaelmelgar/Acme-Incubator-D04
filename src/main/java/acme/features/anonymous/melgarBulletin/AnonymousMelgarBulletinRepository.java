
package acme.features.anonymous.melgarBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.MelgarBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousMelgarBulletinRepository extends AbstractRepository {

	@Query("select m from MelgarBulletin m")
	Collection<MelgarBulletin> findMany();

}
