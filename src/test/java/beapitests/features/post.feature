Feature: This script will create a pet

  Background:
    * url apiUrl
    * def petRequestBody = read('classpath:newPet.json')

  Scenario: create a pet
    Given path 'pets'
    And request petRequestBody
    When method post
    Then status 201
    * print response
    # Assert response
    And match response.name == petRequestBody.name
    And match response.type == petRequestBody.type
    And match response.age == petRequestBody.age
