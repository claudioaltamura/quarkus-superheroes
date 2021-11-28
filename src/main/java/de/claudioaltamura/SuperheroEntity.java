package de.claudioaltamura;

import java.util.Objects;

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

	public Long getSuperheroId() {
		return superheroId;
	}

	public void setSuperheroId(Long superheroId) {
		this.superheroId = superheroId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SuperheroEntity that = (SuperheroEntity) o;
		return Objects.equals(superheroId, that.superheroId) && Objects.equals(name, that.name) && Objects.equals(realName, that.realName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(superheroId, name, realName);
	}

	@Override
	public String toString() {
		return "SuperheroEntity{" +
				"superheroId=" + superheroId +
				", name='" + name + '\'' +
				", realName='" + realName + '\'' +
				'}';
	}
}
