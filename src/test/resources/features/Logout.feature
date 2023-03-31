Feature: Logout functionality
  As a user, I should be able to log out

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given User is on the  login page

  Scenario: The user can log out using the log-out button inside the profile info and end up on the login page
    When The user logs in as a driver
    Then The user logs out using the logout button inside the profile menu
    Then The user ends up on the login page

  Scenario: The user can not go to the home page again by clicking the step back button after successfully logging out
    When The user logs in as a driver
    Then The user logs out using the logout button inside the profile menu
    When The user clicks step back button
    Then The user is still on the login page