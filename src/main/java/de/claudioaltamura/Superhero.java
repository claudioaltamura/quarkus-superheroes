package de.claudioaltamura;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class Superhero {

	@Positive
	private Integer superheroId;

	@NotEmpty
	private String name;

	private String realName;

	public Integer getSuperheroId() {
		return superheroId;
	}

	public void setSuperheroId(Integer superheroId) {
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
		Superhero superhero = (Superhero) o;
		return superheroId.equals(superhero.superheroId) && name.equals(superhero.name) && Objects.equals(realName, superhero.realName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(superheroId, name, realName);
	}

	@Override
	public String toString() {
		return "Superhero{" +
				"superheroId=" + superheroId +
				", name='" + name + '\'' +
				", realName='" + realName + '\'' +
				'}';
	}
}
