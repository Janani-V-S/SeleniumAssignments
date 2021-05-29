Feature: Assign an existing incident

Scenario Outline: Assign an Incident

Given Click Open and Search for an existing incident and open it <IncidentNo>
And Assign Incident and Update Worknotes
Then Verify if Incident is assigned

Examples:
|IncidentNo|
|INC0011520|