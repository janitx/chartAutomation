Feature: Verify Chart functionality

  As user
  I want to test Chart functionality
  so that I can be sure that it works correctly

  Scenario Outline: Check Chart
    Given User opens '<site>'
    Examples:
      | site                                           |
      | https://www.highcharts.com/demo/combo-timeline |
