Feature: Login with valid credentials

@sanity
Scenario: Successful login with valid credentials
Given user navigates to login page
When user enters email as "pavanoltraining@gmail.com" and passwors as "test@123"
And user clicks on Login button
Then user should be redirected to MyAccount Page

@regression
Scenario Outline: Login Data Driven
Given user navigates to login page
When user enters email as "<email>" and password as "<password>"
And user clicks on Login button
Then user should be redirected to MyAccount Page

Examples:
|email                    |password|
|pavanoltraining@gmail.com|test@123|
|pavanol@gmail.com        |test123|