package br.com.clickbus.placems;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.clickbus.placems.api.PlaceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PlacemsApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	public void testCreatePlaceSuccess() {
		var name = "valid Name";
		var city = "valid City";
		var state = "valid State";
		var slug = "valid-name";

		webTestClient
			.post()
			.uri("/places")
			.bodyValue(
					new PlaceRequest(name, city, state)
			)
			.exchange() //Efetua requisição de fato.
			.expectStatus()
				.isCreated()
				.expectBody()
				.jsonPath("$.id").isNotEmpty()
				.jsonPath("$.name").isEqualTo(name)
				.jsonPath("$.slug").isEqualTo(slug)
				.jsonPath("$.city").isEqualTo(city)
				.jsonPath("$.state").isEqualTo(state)
				.jsonPath("$.createdAt").isNotEmpty()
				.jsonPath("$.updatedAt").isNotEmpty()
			;	
	}

	@Test
	public void testCreatePlaceFailure() {
		var name = "";
		var city = "";
		var state = "";

		webTestClient
			.post()
			.uri("/places")
			.bodyValue(
					new PlaceRequest(name, city, state)
			)
			.exchange() //Efetua requisição de fato.
			.expectStatus()
				.isBadRequest()
				//.expectBody()
				//.jsonPath("$.message").isEqualTo("Invalid input")
				//.jsonPath("$.details.name").isEqualTo("must not be blank")
				//.jsonPath("$.details.city").isEqualTo("must not be blank")
				//.jsonPath("$.details.state").isEqualTo("must not be blank")
			;


	}

}
