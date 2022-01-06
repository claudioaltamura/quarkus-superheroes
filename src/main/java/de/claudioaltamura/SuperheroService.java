package de.claudioaltamura;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.slf4j.Logger;

@ApplicationScoped
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
				.map(superheroMapper::toDomain)
				.collect(Collectors.toList());
	}

	public Optional<Superhero> findById(Long superheroId) {
		return superheroRepository.findByIdOptional(superheroId).map(superheroMapper::toDomain);
	}

	@Transactional
	public Superhero save(Superhero superhero) {
		SuperheroEntity entity = superheroMapper.toEntity(superhero);
		superheroRepository.persist(entity);
		return superheroMapper.toDomain(entity);
	}

	@Transactional
	public Superhero update(Superhero superhero) {
		if (superhero.getId() == null) {
			throw new ServiceException("Superhero does not have a superheroId");
		}
		Optional<SuperheroEntity> optional = superheroRepository.findByIdOptional(superhero.getId());
		if (optional.isEmpty()) {
			throw new ServiceException(String.format("No Superhro found for customerId[%s]", superhero.getId()));
		}
		SuperheroEntity entity = optional.get();
		entity.setName(superhero.getName());
		entity.setRealName(superhero.getRealName());
		superheroRepository.persist(entity);
		return superheroMapper.toDomain(entity);
	}

}