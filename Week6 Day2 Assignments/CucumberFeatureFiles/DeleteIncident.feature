Feature: Delete an existing incident

Scenario Outline: Delete an Incident

Given Search for the incident to be deleted <IncidentNo>
And Delete the Incident
Then Verify if Incident is deleted <IncidentNo>

Examples:
|IncidentNo|
|INC0011750|