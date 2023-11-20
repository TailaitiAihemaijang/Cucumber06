Feature: DataTable Ornek

  Scenario:  User List
    When Write usename "Ahmet"
    And  Write username anPassword "Ahmet" and "1234"


    And Write username as DataTable1
      | Alim   |
      | Kurban |
    And Write username and Pssword ad DataTable
      | Alim   | 123 |
      | Kurban | 456 |