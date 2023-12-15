@US001
Feature:

  @TC101
  Scenario Outline: Basic Invalid and Valid register

    Given Go to Url.
    And   Click Create Account button.
    And   Verify that the user is successfully go to register page.
    And   Enter "<firstName>", "<lastName>" and "<email>".
    And   Select "<country>".
    And   Check Privacy Policy and Terms Of Services
    Then  Click continue login button.
    And   Verify that the user is successfully register verify page.

    Examples:
      | firstName | lastName | email                | country |
      | Test123*  | kumcu    | powat82221@gyxmz.com | turkey  |
      | Test123*  | Kumcu    | powat82221@gyxmz.com | turkey  |
      |           | Kumcu    | powat82221@gyxmz.com | turkey  |
      | Test123*  |          | powat82221@gyxmz.com | turkey  |
      | Test123*  | Kumcu    |                      | turkey  |
      | Test123*  | Kumcu    | powat82221@gyxmz.com |         |
      | Test123+  | kumcu    | powat12345.com       | turkey  |
      | Test123+  | kumcu    | powat12345@gyxmz.com | turkey  |

  @TC102
  Scenario Outline: Account Activation via Email

    Given Go to Url.
    And   Register with a valid "<firstName>", "<lastName>", "<email>" address and "<country>".
    Then  Check the email for the activation link.
    And   Click on the activation link
    Then  Verify that the account is activated and the user can log in.

    Examples:
      | firstName | lastName | email                | country |
      | Test123*  | kumcu    | powat82221@gyxmz.com | turkey  |

  @TC103
  Scenario Outline: Password Strength

    Given Go to "mailUrl".
    Then  Click set Password.
    And   Enter "<name>".
    And   Enter a strong "<password>" during registration.
    Then  Verify that the system accepts the password strength criteria.

    Examples:
      | name     | password |
      | Test123* | est655*  |

  @TC104
  Scenario Outline: Weak Password

    Given Go to "mailUrl".
    Then  Click set Password.
    And   Enter "<name>".
    And   Enter a weak "<password>" during registration.
    And   Verify that the system prompts for a stronger password.

    Examples:
      | name     | password |
      | Test123* | Abc123*  |
      | Test123* | ABC1234* |
      | Test123* | abc1234* |
      | Test123* |          |
      | Test123* | Abc12345 |

  @TC105
  Scenario Outline: Mismatched Passwords

    Given Go to "setupUrl".
    And   Enter different passwords in the "<password>" and "<confirm password>" fields.
    And   Verify that the system displays an appropriate error message.

    Examples:
      | password | confirm password |
      | Abc1234* | aBC9876+         |

