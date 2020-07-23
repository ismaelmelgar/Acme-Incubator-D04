
package acme.entities.overtures;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Overture extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Column(length = 100)
	@Length(min = 1, max = 100)
	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				creation;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadline;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				description;

	@Valid
	@NotNull
	private Money				maxMoney;

	@Valid
	@NotNull
	private Money				minMoney;

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@Email
	@NotBlank
	private String				email;

}
