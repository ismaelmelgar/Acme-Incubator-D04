
package acme.entities.accountingRecords;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountingRecord extends DomainEntity {

	// Serialisation identifier

	public static final long	serialVersionUID	= 1L;

	// Attributes

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@NotBlank
	private String				title;

	@NotNull
	private boolean				status;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				creation;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				body;

	//Relationships -----------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private InvestmentRound		investmentRound;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Bookkeeper			bookkeeper;

}
