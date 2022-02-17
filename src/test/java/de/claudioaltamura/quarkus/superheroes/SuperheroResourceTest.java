package de.claudioaltamura.quarkus.superheroes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class SuperheroResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/v1/superheroes")
          .then()
             .statusCode(200);
    }

}