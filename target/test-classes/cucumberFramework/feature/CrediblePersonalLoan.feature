Feature: Personal Loan Application Feature
	Existing User is able to apply for Personal Loan
	
Scenario: Apply for personal loan Happy Path Scenario
	Given Existing user with valid credentials navigates to Credible website
	And   User clicks on personal loan button
	And   User enters personal loan amount
	And   User clicks find my rates button
	And   User enters the purpose of loan 
	And   User enters education level
	And   User enters employment status
	And   User enters annual income
	And   User click continue button
	And   User enters credit score
	And   User enters first name and last name
	And   User click continue button
	And   User enters date of birth
	And   User click continue button
	And   User enters home address 
	And   User click continue button
	And   User enters residential status
	And   User enters housing payment
	And   User click continue button
	And   User enters US citizen status
	And   User enters SSN
	And   User click continue button
	And   User enters phone number
	And   User click continue button
	And   User enters email address 
	And   User click continue button
	And   User enters valid password
#	And   User hit agree 
#	And   User click continue button
	Then  User gets personal loan qoute