Feature: Login functionalities with valid credentials
  User Story :
  As a user, I should be able to log in.

  Background:For the scenarios in the feature file, user is expected to be on login page
    Given User is on the  login page


  Scenario: Login as a driver
    When The user logs in as a driver
    Then The user is on the Quick Launchpad page

  Scenario: Login as a sales manager
    When The user logs in as a sales manager
    Then The user is on the Dashboard page

  Scenario: Login as a store manager
    When The user logs in as a store manager
    Then The user is on the Dashboard page


  Scenario: User can NOT login with invalid credentials
    When The user enters invalid username and password
    Then The user sees 'Invalid username or password'

  Scenario: User sees warning message if username OR password input box is empty
    When The user leaves the username or password input box empty
    Then The user sees 'Please fill in this field' warning message

  Scenario: User sees a warning message if BOTH username AND password input boxes are empty
    When The user leaves both username and password input boxes are empty and clicks on login button
    Then The user sees 'Please fill in this field' warning message only in the username input box

  Scenario: The driver sees their own "username" in the profile menu after login
    When The user logs in as a driver
    Then The driver sees their own username in the profile menu

  Scenario: The sales manager sees their own "username" in the profile menu after login
    When The user logs in as a sales manager
    Then The sales manager sees their own username in the profile menu

  Scenario: The store manager sees their own "username" in the profile menu after login
    When The user logs in as a store manager
    Then The store manager sees their own username in the profile menu