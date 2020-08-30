
package acme.entities.toolRecords;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@NotBlank
	private String				title;

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@NotBlank
	private String				activitySector;

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@NotBlank
	private String				inventor;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				description;

	@Column(length = 200)
	@Length(min = 1, max = 200)
	@URL
	@NotBlank
	private String				web;

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@Email
	@NotBlank
	private String				email;

	private Boolean				sourceType;

	@Range(min = -5, max = 5)
	private Integer				stars;

}
