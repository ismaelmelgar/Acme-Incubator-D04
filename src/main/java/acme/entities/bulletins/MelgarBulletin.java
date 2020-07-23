
package acme.entities.bulletins;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MelgarBulletin extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@NotBlank
	private String				author;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				text;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

}
