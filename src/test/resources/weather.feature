Feature: Testing Framework
  @ValidConnection
  Scenario: Accepted and received a request
    Given I have sent an HTTP request
    When it is received by the server
    Then the Status code should be valid

  @RequestAnswered
 Scenario: Response is given
   Given I have made a successful request
    When I get a response
   Then response type is HttpResponse<String>

  @RequestAnswered
  Scenario: Injecting response into Classes
    Given I have response of type HttpResponse<String>
    When I process this data
    Then A DTO is created





