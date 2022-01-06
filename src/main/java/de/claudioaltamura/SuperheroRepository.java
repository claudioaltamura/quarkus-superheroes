package de.claudioaltamura;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class SuperheroRepository implements PanacheRepositoryBase<SuperheroEntity, Long> {
}