
package acme.entities.messages;

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

import acme.entities.forums.Forum;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends DomainEntity {

	// Serialisation identifier

	private static final long	serialVersionUID	= 1L;

	// Attributes

	@Column(length = 50)
	@Length(min = 1, max = 50)
	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creation;

	@Column(length = 200)
	@Length(max = 200)
	private String				tags;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	@NotBlank
	private String				body;

	//Relationships -----------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Forum				forum;

}
