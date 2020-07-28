
package acme.features.bookkeeper.investmentRounds;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BookkeeperInvestmentRoundRepository extends AbstractRepository {

	@Query("select ir from InvestmentRound ir where ir.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select distinct ar.investmentRound from AccountingRecord ar where ar.bookkeeper.id = ?1")
	Collection<InvestmentRound> findManyByBookkeeperId(int bookkeeperId);

	@Query("select ir from InvestmentRound ir where ir.id = ?1")
	InvestmentRound findOneInvestmentRoundById(int id);

	@Query("select wp from WorkProgramme wp join wp.investmentRound ir where ir.id = ?1")
	Collection<WorkProgramme> findWorkProgrammeByInvestmentRoundId(int id);

	//	@Query("select ir from InvestmentRound ir where ir not in (select ar.investmentRound from AccountingRecord ar where ar.bookkeeper.id = ?1)  and ir.status=1 ")
	@Query("select i from InvestmentRound i where i not in (select ar.investmentRound from AccountingRecord ar where ar.bookkeeper.id = ?1) ")
	Collection<InvestmentRound> findManyByNonBookkeeperId(int bookkeeperId);
}
