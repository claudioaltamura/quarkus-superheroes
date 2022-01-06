package de.claudioaltamura;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")

public interface SuperheroMapper {

	SuperheroEntity toEntity(Superhero domain);

	Superhero toDomain(SuperheroEntity entity);

}