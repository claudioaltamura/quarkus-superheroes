package de.claudioaltamura.quarkus.superheroes;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;

@ApplicationScoped
@Transactional
public class SuperheroService {

	private final SuperheroRepository superheroRepository;
	private final SuperheroMapper superheroMapper;
	private final Logger logger;

	public SuperheroService(SuperheroRepository superheroRepository, SuperheroMapper superheroMapper, Logger logger) {
		this.superheroRepository = superheroRepository;
		this.superheroMapper = superheroMapper;
		this.logger = logger;
	}

	public List<Superhero> findAll(){
		return superheroRepository.findAll().stream()
				.map(superheroMapper::toDto)
				.collect(Collectors.toList());
	}

	public Superhero findById(@NotNull Long superheroId) {
		return superheroRepository.findByIdOptional(superheroId)
				.map(superheroMapper::toDto)
				.orElseThrow(()->new SuperheroNotFoundException(String.format("Superhero (id=%d) not found.", superheroId)));
	}

	public Superhero save(@Valid Superhero superhero) {
		final SuperheroEntity entity = superheroMapper.toEntity(superhero);
		superheroRepository.persist(entity);
		return superheroMapper.toDto(entity);
	}

	public Superhero update(@Valid Superhero superhero) {
		return superheroRepository.findByIdOptional(superhero.getId())
				.map(entity -> {
					entity.setName(superhero.getName());
					entity.setRealName(superhero.getRealName());
					superheroRepository.persist(entity);
					return superheroMapper.toDto(entity);
				})
				.orElseThrow(()->new SuperheroNotFoundException(String.format("Superhero (id=%d) not found.", superhero.getId())));
	}

	public boolean deleteById(@NotNull  Long superheroId) {
		final SuperheroEntity superheroEntity = superheroRepository.findById(superheroId);
		if(superheroEntity == null) {
			throw new SuperheroNotFoundException(String.format("Superhero (id=%d) not found.", superheroId));
		}
		return superheroRepository.deleteById(superheroId);
	}

}