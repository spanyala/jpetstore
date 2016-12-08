Feature: LogOut Feature File
@LogOut
Scenario: LogOut scenario test for Jpetstore

Given navigate to jpetstore page to Log in and logout
When user logged in using username And password  And log out 
Then log in  page should be displayed with