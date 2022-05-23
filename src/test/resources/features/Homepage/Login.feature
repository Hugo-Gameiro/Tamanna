Feature: Login

  @Login
  Scenario Outline: Validate login functionality
    Given access to homepage
    When I select the "Enter Credentials" button
    And introduce the "<Username>" and "<Password>"
    And I select the "Submit" button
    Then I verify that I am at "Homepage" according to "<Success>" message

    Examples:
      | Username | Password      | Success |
      | Topas    | 12345         | true    |
      | Topas    | wrongPassword | false   |
      |          |               | false   |