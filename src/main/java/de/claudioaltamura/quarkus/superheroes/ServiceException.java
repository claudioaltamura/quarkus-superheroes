package de.claudioaltamura.quarkus.superheroes;

public class ServiceException extends RuntimeException {

		public ServiceException(String message) {
			super(message);
		}

}
