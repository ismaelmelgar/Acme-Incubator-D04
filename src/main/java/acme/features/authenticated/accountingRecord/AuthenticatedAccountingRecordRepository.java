/*
 * EntrepreneurProviderRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.accountingRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.accountingRecords.AccountingRecord;
import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAccountingRecordRepository extends AbstractRepository {

	@Query("select ar from AccountingRecord ar where ar.id = ?1")
	AccountingRecord findOneById(int id);

	@Query("select ar from AccountingRecord ar where ar.status = 1")
	Collection<AccountingRecord> findMany();

	@Query("select ar from AccountingRecord ar where ar.investmentRound.id = ?1 and ar.status = 1")
	Collection<AccountingRecord> findManyByInvestmentRoundId(int entrepreneurId);

	@Query("select ac.investmentRound from AccountingRecord ac where ac.id = ?1")
	InvestmentRound findInvestmentRoundByAccountingRecordId(int id);
}
