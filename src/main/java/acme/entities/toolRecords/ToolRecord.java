
package acme.entities.toolRecords;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToolRecord extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	public static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Length(min = 1, max = 50)
	private String				title;

	@Length(min = 1, max = 50)
	private String				activitySector;

	@Length(min = 1, max = 50)
	private String				inventor;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	private String				description;

	@Length(min = 1, max = 200)
	@URL
	private String				web;

	@Length(min = 1, max = 50)
	@Email
	private String				email;

	@NotNull
	private boolean				sourceType;

	@Range(min = -5, max = 5)
	private Integer				stars;

}
