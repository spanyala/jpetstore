Feature: Login Feature File
@Login
Scenario: Login scenario test for Gmail

Given navigate to gmail page
When user logged in using username And password 
Then home page should be displayed

