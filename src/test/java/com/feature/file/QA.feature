Feature: Testing QA fake Application end to end process

Scenario: Verify the user is able to login the application
Given User launch the url
When User enter the valid username 
And User enter the valid password
And User able to click the remember me checkbox
And user able to click the login button
Then User verify the login is successful
