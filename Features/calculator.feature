Feature: Calculator Operations

  Scenario Outline: Perform Calculation
    Given I open the calculator website
    When I enter number1 "<n1>"
    And I select "<op>" operation
    And I enter number2 "<n2>"
    Then the result should be "<result>"
    And Click All Clear and Close

    Examples: 
      | n1      | n2        | op | result   |
      |     423 |       525 | *  |   222075 |
      |    4000 |       200 | /  |       20 |
      | -234234 |    345345 | +  |   111111 |
      |  234823 | -23094823 | -  | 23329646 |
