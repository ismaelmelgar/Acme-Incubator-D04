
package acme.entities.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customisation extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Column(length = 200)
	@Length(min = 1, max = 200)
	@NotBlank
	private String				spamWords;

	@Range(min = 0, max = 100)
	@NotNull
	private Double				threshold;

	@Column(length = 500)
	@Length(min = 1, max = 200)
	@NotBlank
	private String				activitySectors;

}
