package de.claudioaltamura;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity(name = "Superhero")
@Table(name = "superhero")
public class SuperheroEntity {

	@Positive
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "real_name")
	private String realName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(realName, that.realName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, realName);
	}

	@Override
	public String toString() {
		return "SuperheroEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", realName='" + realName + '\'' +
				'}';
	}
}
