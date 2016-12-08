Feature: Login Feature File
@Login
Scenario: Login scenario test for Jpetstore

Given navigate to jpetstore page to Log in
When user logged in using username And password 
Then home page should be displayed

