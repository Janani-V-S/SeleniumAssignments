Feature: Duplicate an existing Lead

Scenario Outline: Duplicate a lead

Given DuplicateLead-Launch Chrome Browser
When DuplicateLead-Load the URL 'http://leaftaps.com/opentaps/control/login'
And DuplicateLead-Enter the username 'DemoSalesManager'
And DuplicateLead-Enter the password 'crmsfa'
And DuplicateLead-Click Login button
And DuplicateLead-Click CRMSFA
And Click Leads link DuplicateLead-
And Click Find leads
And Click on Email
And	Enter Email as <Email>
And	Click find leads button
And	Capture name of First Resulting lead
And	Click First Resulting lead
And	Click Duplicate Lead
And	Verify the title as Duplicate Lead
And	Click Create Lead
And	Confirm the duplicated lead name is same as captured name
And	Close the browser

Examples:
|Email|
|aaa@gmail.com|
|bbb@gmail.com|