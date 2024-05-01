Feature: This script will create a pet

  Background:
    * url 'http://localhost:8080'

  Scenario: create a pet
    * def pet =
    """
    {
        "name": "Rex from karate",
        "type": "DOG",
        "age": 10
    }
    """
    Given path 'pets'
    And request pet
    When method post
    Then status 201
    * print response
    And match response.name == pet.name
    And match response.type == pet.type
    And match response.age == pet.age
