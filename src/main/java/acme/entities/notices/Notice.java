
package acme.entities.notices;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Notice extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Column(length = 200)
	@Length(min = 1, max = 200)
	@NotBlank
	@URL
	private String				header;

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
	private String				body;

	@Column(length = 200)
	@Length(max = 200)
	@URL
	private String				link;

	@NotNull
	private Boolean				finalMode;

}
