Feature: Verify Chart functionality

  As user
  I want to test Chart functionality
  so that I can be sure that it works correctly

  Scenario: Check Chart
    Given User reads file
    When User opens site
    When User confirms cookies
    When User reads tooltips
    Then User checks tooltips
