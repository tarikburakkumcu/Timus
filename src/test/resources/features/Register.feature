@US001
Feature:

  @TC101
  Scenario Outline: Basic Invalid and Valid register

    Given Go to Url.
    And   Click Create Account button.
    And   Verify that the user is successfully go to register page.
    And   Enter "firstName", "lastName" and "email".
    And   Select "country".
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
  Scenario: Account Activation via Email

    Given Go to Url.
    And   Register with a valid email address.
    Then  Check the email for the activation link.
    And   Click on the activation link
    Then  Verify that the account is activated and the user can log in.

  @TC103
  Scenario: Password Strength

    Given Go to Url.
    And   Enter a strong password during registration.
    Then  Verify that the system accepts the password strength criteria.

  @TC104
  Scenario: Weak Password

    Given Go to Url.
    And   Enter a weak password during registration.
    Then  Call the registration method.
    And   Verify that the system prompts for a stronger password.

  @TC105
  Scenario: Mismatched Passwords

    Given Go to Url.
    And   Enter different passwords in the "Password" and "Confirm Password" fields.
    Then  Call the registration method.
    And   Verify that the system displays an appropriate error message.

