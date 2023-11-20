Feature: ApachePOI Citizen funtionality


  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship

    Scenario: Create and Delete CitizenShip from excel
      When User create citizenship with ApachePOI
      Then User delete citizensip with ApachePOI