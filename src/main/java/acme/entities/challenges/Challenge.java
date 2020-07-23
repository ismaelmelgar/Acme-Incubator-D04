
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadline;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				description;

	@Column(length = 200)
	@Length(min = 1, max = 200)
	@NotBlank
	private String				rookieGoal;

	@Valid
	@NotNull
	private Money				rookieReward;

	@Column(length = 200)
	@Length(min = 1, max = 200)
	@NotBlank
	private String				averageGoal;

	@Valid
	@NotNull
	private Money				averageReward;

	@Column(length = 200)
	@Length(min = 1, max = 200)
	@NotBlank
	private String				expertGoal;

	@Valid
	@NotNull
	private Money				expertReward;

}
