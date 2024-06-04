#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login and Dashboard Functionality
 
  Background:
    Given User is on the login page
    When User enters valid username and password
    And Click on login button
 
  Scenario: Dashboard Functionality
    Then User is navigated to Dashboard page1
    And Click on the desired URL on dashboard page1
    Then Go to the Actual Portal
    Then Go to the Configure Tab
    Then Click on the Advance setting button
    Then Setting pop-up opened
  
  Scenario: Login Functionality
    And Close the browser