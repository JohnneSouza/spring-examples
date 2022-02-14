package org.acme.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthSteps  {

    TestRestTemplate testRestTemplate;

    public HealthSteps(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    private HttpStatus responseStatus;

    @Given("the application has started")
    public void theApplicationHasStarted() {
    }

    @When("a request is made to the {string} endpoint")
    public void aRequestIsMadeToTheEndpoint(String url) {
        ResponseEntity<String> forEntity = this.testRestTemplate.getForEntity(url, String.class);
        this.responseStatus = forEntity.getStatusCode();
    }

    @Then("the response should be {string}")
    public void theResponseShouldBe(String status) {
        HttpStatus httpStatus = HttpStatus.valueOf(status);
        assertEquals(httpStatus, responseStatus);
    }
}
