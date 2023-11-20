Feature:  DateTabel Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create Country
    And  Click on the elment in LeftNav
      | setup      |
      | parameters |
      | counteries |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | <name> |
      | codeInput | <code> |
    And Click on the element in Dialog
      | saveButton |
    When Success message should be displayed
    And User delete the element from Dialog
      | <name> |
    Then Success message should be displayed
    Examples:
      | name   | code    |
      | Alim   | alim1   |
      | Kurban | kurban2 |
      | Mehmet | mehmet1 |