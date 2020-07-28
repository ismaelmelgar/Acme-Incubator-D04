
package acme.entities.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bookkeeper extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(length = 100)
	@Length(min = 1, max = 100)
	@NotBlank
	private String				name;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				responsibilityStatement;

}
