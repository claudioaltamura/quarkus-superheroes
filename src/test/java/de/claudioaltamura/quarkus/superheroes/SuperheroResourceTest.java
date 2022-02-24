package de.claudioaltamura.quarkus.superheroes;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@QuarkusTest
@TestHTTPEndpoint(SuperheroResource.class)
class SuperheroResourceTest {

	@InjectMock
	private SuperheroService superheroService;

	private List<Superhero> superheroes() {
		List<Superhero> superheroes = new ArrayList<>();
		superheroes.add(new Superhero(1L, "Spider-Man","Peter Parker"));
		return superheroes;
	}

    @Test
    void testHelloEndpoint() {
		Mockito.when(superheroService.findAll()).thenReturn(superheroes());
        given()
          .when().get()
          .then()
             .statusCode(200);
    }

}