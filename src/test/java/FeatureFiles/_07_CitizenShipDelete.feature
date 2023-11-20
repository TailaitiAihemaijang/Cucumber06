Feature: CitizenShip Delet

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship

  Scenario Outline: Create a CitizenShip
    When Create a Citizenship name as "<name>" short name as "<shortname>"
    Then Success message should be displayed
    Examples:
      | name        | shortname  |
      | alimjan1111 | mahmut1111 |
      | alijan2222  | Tarim2222  |

  Scenario Outline: Delet a CitizenShip
    When Delet a CitizenShip name as "<name>" short name as "<shortname>"
    Then Success message should be displayed
    Examples:
      | name        | shortname  |
      | alimjan1111 | mahmut1111 |
      | alijan2222  | Tarim2222  |

