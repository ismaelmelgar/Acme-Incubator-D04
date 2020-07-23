
package acme.entities.investmentRounds;

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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.datatypes.Round;
import acme.entities.roles.Entrepreneur;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestmentRound extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Column(length = 13)
	@Length(min = 1, max = 13)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}[-][0-9]{2}[-][0-9]{6}$")
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				creationMoment;

	@NotNull
	private Round				round;

	@Column(length = 100)
	@Length(min = 1, max = 100)
	@NotBlank
	private String				title;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				description;

	@Valid
	@NotNull
	private Money				amountMoney;

	@Column(length = 200)
	@Length(max = 200)
	@URL
	private String				moreInfo;

	//Relationships -----------------------------------------------------

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	private Entrepreneur		entrepreneur;

}
