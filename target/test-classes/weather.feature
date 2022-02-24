Feature: Successful connection
  @ValidConnection
  Scenario: Accepted and received a request
    Given I have sent an HTTP request
    And it is received by the server
    When it is accepted
    Then the Status code should be 2XX

#  @InvalidURL
#  Scenario: Invalid URL Entered
#  Given I have sent an HTTP request
#  And it is received by the server
#  When not found
#  Then the Status code should be 404
#
#  @
#  Scenario: Request is answered with JSON
#    Given I have made a successful request
#    And the request is answered
#    When I receive a response
#    Then response type is JSON




