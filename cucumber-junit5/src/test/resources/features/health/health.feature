Feature: Test Application Health

  Scenario: Health Ok
    Given the application has started
    When a request is made to the "/actuator/health" endpoint
    Then the response should be "OK"