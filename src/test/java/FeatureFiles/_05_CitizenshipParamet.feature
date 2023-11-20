Feature: Citizenship Functionality
  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship


    Scenario: Create a Citizenship
      When Create a Citizenship name as "ahmet" short name as "karatal"
      Then Success message should be displayed

      When Create a Citizenship name as "merdan" short name as "yavuz"
      Then Already exist message should be displayd