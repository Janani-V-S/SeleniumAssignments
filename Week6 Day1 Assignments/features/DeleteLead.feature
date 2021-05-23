Feature: Delete an existing Lead

Scenario Outline: Delete a Lead

Given DeleteLead-Launch Chrome Browser
When DeleteLead-Load the URL 'http://leaftaps.com/opentaps/control/login'
And DeleteLead-Enter the username 'DemoSalesManager'
And DeleteLead-Enter the password 'crmsfa'
And DeleteLead-Click Login button
And DeleteLead-Click CRMSFA
And Click Leads Link
And Click Find Leads button
And Click on Phone
And Enter Phone Number as <PhoneNumber>
And Click FindLeads button
And Capture Lead ID of first result
And Click First Resulting Lead
And Click Delete
And Click FindLeads
And Enter captured Lead ID
And Click find Leads option
And Verify the message

Examples:
|PhoneNumber|
|1|
|2|