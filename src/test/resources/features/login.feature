@login
Feature: Login as different users

  Background:
    Given the user opens the login page

  @INN-870
  Scenario Outline: Login with valid credentials for different accounts
    When the user logs in using "<username>" and "<password>"
    And the user should be able to login
    Then the title contains "<title>"

    Examples:
      | username        | password    | title           |
      | user1           | UserUser123 | Quick Launchpad |
      | salesmanager101 | UserUser123 | Dashboard       |
      | storemanager51  | UserUser123 | Dashboard       |

  @INN-871
  Scenario Outline: The system shouldn't allow users to login to application without providing valid credentials
    When the user logs in using "<username>" and "<password>"
    And the user should be able to login
    And the user copies the url and logs out
    And the user tries to login by clicking back button
    And the user is also on the login page
    And the user tries to login by pasting the same url in the browser
    Then the user is also on the login page

    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |

  @INN-872
  Scenario Outline: User can see their own username in profile menu
    When the user logs in using "<username>" and "<password>"
    Then the user should be able to login
    And the user can see own "<name>" in profile menu

    Examples:
      | username        | password    | name            |
      | user1           | UserUser123 | John Doe        |
      | salesmanager101 | UserUser123 | Peyton Harber   |
      | storemanager51  | UserUser123 | Geovany Jenkins |

  @INN-873
  Scenario Outline: Login functions with invalid credentials for different users
    When the user logs in using "<username>" and "<password>"
    Then the following "Invalid user name or password." should be displayed

    Examples:
      | username        | password    |
      | wrong           | wrong       |
      | user1           | wrong       |
      | wrong           | UserUser123 |
      | salesmanager101 | wrong       |
      | storemanager51  | wrong       |

  @INN-874
  Scenario: User should see the password in bullet signs by default
    When write anything in password inputbox
    And verify it is masked or not

  @INN-875
  Scenario: User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    When the user clicks on the Forgot your password? link
    And the user should be able to login Forgot Password page

  @INN-878
  Scenario: User can see "Remember me on this computer" link on the login page and it should be clickable
    When the user can click link
    And the link should be clickable

  @INN-876
  Scenario Outline: Verify that user can use "Enter" key from their keyboard on the login page
    When write a valid "<username>" in username inputbox and hit Enter button
    Then write a valid "<password>" in password inputbox and hit Enter button
    And the user should be able to login

    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |

