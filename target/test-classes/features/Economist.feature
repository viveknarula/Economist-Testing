Feature: Jobsite for Economist 
	Description: As a user, I want to check the navigation to Economist Jobsite working properly.

@functionalUIEconomist1
Scenario: Validate Page Renderation for Economist Jobsite 
	Given the user launches the application 
	Then validate Navigation Bars, Search field, Sector List,SignIn and Create Account working correctly 
	
@functionalUIEconomist 
Scenario: Validate Navigation Bar is navigating to correct pages 
	Given the user launches the application 
	Then user validate the navigation bar links is navigating to correct links 
	
@functionalUIEconomist 
Scenario: Validate Signin and CreateAccount is navigating to correct pages 
	Given the user launches the application 
	Then user validate the Signin and CreateAccount links is navigating to correct pages 
	
@functionalUIEconomist
Scenario: Validate the user is able to apply the job by sector 
	Given the user launches the application 
	When user click the job by each sector and click view detail button then verify the user is able to apply the job 
	
	
@functionalUIEconomist 
Scenario: Validate the user is able to search the job with correct text field 
	Given the user launches the application 
	When user fills out the data in search section 
		| Keyword | Country   | 
		| Director   | UK |
	And user select the "10" from dropdown value 
	And user "click" Search button 
	Then validate search list displayed on page
	
@functionalUIEconomist
Scenario: Validate the user is not able to search the job with incorrect text field
Given the user launches the application
When user fills out the data in search section
      | Keyword | Country   | 
      | InvalidTest   | UK |
And user select the "15" from dropdown value
And user "click" Search button
Then validate "Found 0 jobs using the term " from search page
	
	
	
	
