Feature: Resolve Incident

Scenario Outline: Resolve an existing Incident

Given Search for an existing Incident that has to be resolved <IncidentNo>
And Update Incident resolution details
Then Verify if Incident is Resolved

Examples:
|IncidentNo|
|INC0011521|