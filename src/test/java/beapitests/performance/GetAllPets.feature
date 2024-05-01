Feature: This is get requests script

  Background:
    * url apiUrl

  Scenario: get all pets
    Given path 'pets'
    When method get
    Then status 200