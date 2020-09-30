package com.example.enumerrorexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EnumerrorexampleApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	void defaultValue() {
		String query = "{\"query\":\"{\\n  foos {\\n    status,\\n    bar {\\n      name\\n    }\\n  }\\n}\",\"variables\":{}}";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity(query, headers);
		ResponseEntity<String> response = restTemplate.exchange("/graphql", HttpMethod.POST, entity, String.class);

		assertThat(response.getBody().contains("errors")).isFalse();
	}

	@Test
	void givenValue() {
		String query = "{\"query\":\"{\\n  foos(fooStatus:GOOD) {\\n    status,\\n    bar {\\n      name\\n    }\\n  }\\n}\",\"variables\":{}}";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity(query, headers);
		ResponseEntity<String> response = restTemplate.exchange("/graphql", HttpMethod.POST, entity, String.class);

		assertThat(response.getBody().contains("errors")).isFalse();
	}

	@Test
	void givenValueList() {
		String query = "{\"query\":\"{\\n  foos(fooStatus:[GOOD, BAD]) {\\n    status,\\n    bar {\\n      name\\n    }\\n  }\\n}\",\"variables\":{}}";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity(query, headers);
		ResponseEntity<String> response = restTemplate.exchange("/graphql", HttpMethod.POST, entity, String.class);

		assertThat(response.getBody().contains("errors")).isFalse();
	}
}



