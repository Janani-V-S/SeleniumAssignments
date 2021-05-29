Feature: Update incident

Scenario Outline: Update an Existing Incident

Given Search for the Incident <IncidentNo>
And Update Incident Urgency and State
Then Verify if Incident is updated

Examples:
|IncidentNo|
|INC0011516|