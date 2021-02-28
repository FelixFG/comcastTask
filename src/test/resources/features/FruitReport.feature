Feature: Getting a report from a path provided input file.

  @comcast
  Scenario: User should be able to get the report of some attributes from the file
    Given User provides the path of the file
    And System Asserts the file exists and file structure matches
    Then User receives a system generated report