package de.claudioaltamura.quarkus.superheroes;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class SuperheroRepository implements PanacheRepositoryBase<SuperheroEntity, Long> {

	public List<SuperheroEntity> findByName(String name){
		return find("name", name).list();
	}
}