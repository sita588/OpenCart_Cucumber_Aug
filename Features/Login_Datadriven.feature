Feature: Login Data Driven with Excel

Scenario Outline: Login Data Driven Excel
Given user navigates to login page
Then user should be redirected to MyAccount page by passing email and password with excel row "<row_index>"

Examples:
|row_index|
|1|
|2|
|3|