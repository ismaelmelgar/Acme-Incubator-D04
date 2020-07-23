
package acme.features.anonymous.minuesaBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.MinuesaBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousMinuesaBulletinRepository extends AbstractRepository {

	@Query("select m from MinuesaBulletin m")
	Collection<MinuesaBulletin> findMany();

}
