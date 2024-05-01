Feature: This script will create and delete a pet

  Background:
    * url apiUrl
    * def petRequestBody = read('classpath:newPet.json')

  Scenario: delete a pet
    # Create pet
    Given path 'pets'
    And request petRequestBody
    When method post
    Then status 201
    * def id = response.id

    # Verify pet was created, path param used
    Given path `pets/${id}`
    When method get
    Then status 200

    # Delete pet, path param used
    Given path `pets/${id}`
    When method delete
    Then status 200

    # Verify that pet was deleted, path param used
    Given path `pets/${id}`
    When method get
    Then status 404
