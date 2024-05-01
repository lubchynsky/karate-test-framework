Feature: This is get requests script

  Background:
    * url apiUrl

  Scenario: get all pets
    Given path 'pets'
    When method get
    Then status 200
    * print response

  Scenario: get N pets with query param
    * def limit = 2
    Given path 'pets'
    # Query param
    And param n = limit
    When method get
    Then status 200
    # Verify size of returned object in response with #[..]
    And match response == `#[${limit}]`
    # Alternative way
    And assert response.length == limit