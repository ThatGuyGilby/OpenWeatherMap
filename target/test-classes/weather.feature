Feature: Testing Framework
  @ValidConnection
  Scenario: Approved sent request
    Given I have sent an HTTP request
    When it is received by the server
    Then the Status code should be valid

  @RequestAnswered
 Scenario: Response is received as HttpResponse<String>
   Given I have made a successful request
    When I get a response
   Then response type is HttpResponse<String>

  @GetWeather
  Scenario: Get the Wind data
    Given I have response of type HttpResponse<String>
    When I process this data
    Then I can get the wind





