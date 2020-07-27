
package acme.features.authenticated.workProgrammes;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedWorkProgrammeRepository extends AbstractRepository {

	@Query("select wp from WorkProgramme wp where wp.id = ?1")
	WorkProgramme findOneById(int id);

	@Query("select wp from WorkProgramme wp join wp.investmentRound ir where ir.id = ?1")
	Collection<WorkProgramme> findWorkProgrammeByInvestmentRoundId(int id);

}
