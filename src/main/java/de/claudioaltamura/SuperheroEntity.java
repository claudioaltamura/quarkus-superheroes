package de.claudioaltamura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Superhero")
@Table(name = "superhero")
public class SuperheroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "superhero_id")
	private Long superheroId;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "real_name")
	private String realName;

}
