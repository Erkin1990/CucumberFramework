
Feature: Verifying number of Europe Employees and Active Employees

  @TECT-999
  Scenario: Verifying number of employees from Europe
    Given User goes to HR homepage
    When User gets first and last names of the employees from homepage
    And User counts the number of the employees from the homepage
    And User gets first and last names from database and counts
    And User compares the both data
    Then User updates the excel file for documentation