Feature: This script will create a pet

  Background:
    # Inject java class
    * def petGenerator = Java.type('helpers.PetRandomizer')
    * url apiUrl
    * def petRequestBody = read('classpath:newPet.json')
    # Setup pet from random values
    * petRequestBody.name = petGenerator.getPetName();
    * petRequestBody.type = petGenerator.getPetType();
    * petRequestBody.age = petGenerator.getPetAge();

  Scenario: create a pet
    Given path 'pets'
    And request petRequestBody
    When method post
    Then status 201
    * print response
