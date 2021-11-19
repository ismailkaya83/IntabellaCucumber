@logout
Feature: Logout Functionality

  Background:
    Given the user is on the Dashboard page

  @INN-881
  Scenario:User can log out by using log out button inside profile info and ends up in login page.
    When click the profile menu button
    And click the logout button
    Then verify it is login page

  @INN-883
  Scenario:The user can not go to the home page again by clicking the step back button after successfully logged out.
    When click the profile menu button
    And click the logout button
    And the user is also on the login page
    And click the back button
    Then verify it is not dashboard page

  @INN-884
  Scenario:The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    When close all tabs
    And open browser again with same url
    Then verify it is not dashboard page