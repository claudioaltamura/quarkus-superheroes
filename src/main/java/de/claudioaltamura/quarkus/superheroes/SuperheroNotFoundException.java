package de.claudioaltamura.quarkus.superheroes;

public class SuperheroNotFoundException extends RuntimeException {

		public SuperheroNotFoundException(String message) {
			super(message);
		}

}
