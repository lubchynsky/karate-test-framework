Feature: This is get requests script

  Background:
    * url 'http://localhost:8080'

  Scenario: get all pets
    Given path 'pets'
    When method get
    Then status 200