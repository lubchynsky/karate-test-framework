Feature: This script will create and delete a pet

  Background:
    * url 'http://localhost:8080'

  Scenario: delete a pet
    * def pet =
    """
    {
        "name": "Rex from karate",
        "type": "DOG",
        "age": 10
    }
    """
    # Create pet
    Given path 'pets'
    And request pet
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
