Feature: Testing Framework
  @ValidConnection
  Scenario: Accepted and received a request
    Given I have sent an HTTP request
    And it is received by the server
    When it is accepted
    Then the Status code should be valid

Feature: Getting response
  @RequestAnswered
 Scenario: Response is given and taken as String
   Given I have made a successful request
    When I get a response
   Then response type is HttpResponse<String>

Feature: Converting String to Classes
  @RequestAnswered
  Scenario: Injecting objects into Classes
    Given I have received a response
    When I process this data
    Then Each Class should hold the relevant data





