@US001
Feature:

  @TC001
  Scenario Outline: Basic Invalid and Valid Log in

    Given Go to Url.
    And   Enter "<email>" and "<password>".
    Then  Click Continue login button.

    Examples:
      | email                  | password |
      | powat82221@gyxmz.com   | Test655  |
      | 1@gmail.com            | Test655* |
      |                        | Test655* |
      | powat82221@gyxmz.com   |          |
      | timusberqnet@gmail.com | Test123* |

  @TC002
  Scenario Outline: Log in with Remember Me Option

    Given Go to Url.
    And   Check the Remember Me option.
    Then  Log in with "<email>" and "<password>"
    And   Reopen the browser and verify that the user is still logged in automatically.

    Examples:
      | email                  | password |
      | timusberqnet@gmail.com | Test123* |

  @TC003
  Scenario Outline: Password Reset

    Given Go to Url.
    And   Click on the Forgot Password link.
    Then  Enter a "<email>" address and submit the form.
    And   Check the email for the password reset link.
    Then  Set a new "<password>" using the link.
    And   Log in with the new "<email>","<password>".

    Examples:
      | email                  | password |
      | timusberqnet@gmail.com | Test123* |

  @TC004
  Scenario: Close Browser

    Given close the browser.
