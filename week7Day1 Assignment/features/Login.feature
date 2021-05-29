Feature: Create New Lead

Scenario Outline: Create New Lead

And Enter the username 'DemoSalesManager'
And Enter the password 'crmsfa'
And Click Login button
And Click CRMSFA
And Click Create Leads 
And Enter Company Name as <CompanyName>
And Enter First Name as <FirstName>
And Enter Last Name as <LastName>
And Click Submit
Then Verify if New lead is created

Examples:
|CompanyName|FirstName|LastName|
|Accenture|Janani|VS|