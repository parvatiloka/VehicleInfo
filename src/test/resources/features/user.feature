Feature: user
As a user of the website I want to be able to enter a vehicle registration number and get
the correct make and colour of the cars I own back from the website.

Scenario: The user enters a correctly formated registration plate
Given I am a user of the website
When I enter a correct registration plate of NG07NNT
And press continue
Then I will receive the correct make as FORD and colour of car as BLUE

Scenario: The user enters a invalid registration plate
Given I am a user of the website
When I enter a correctly formatted invalid registration plate of V765DPR
And press continue
Then I will be taken to an error page

Scenario: The user enters an incorrectly formatted registration plate
Given I am a user of the website
When I enter a incorrectly formatted registraton plate of AB343467
And press continue
Then I will receive an error messsage on the same page








