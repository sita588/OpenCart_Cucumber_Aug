Feature:Account Registration

@regression
Scenario: Successful Registration
Given user navigates to Account Register Page
When user enters below details
|firstname|Johny    |
|lastname |kenedy   |
|telephone|123456789|
|password |test@123 |
And user selects privacy policy
And user clicks on continue button
Then user account should be created
