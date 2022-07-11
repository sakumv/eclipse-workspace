Feature: Validating Place APIs

@addPlace @regression
Scenario Outline: Verify place is added through addplace API
	Given Add place payload with "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "post" http request
	Then api call is success with status code is 200
	And "status" in response Body is "OK"
	And "scope" in response Body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name	|language	|address 				|
	|Test	|Tamil		|Cabot place 			|
	|Portnov|Russian	|Sunnyvale, LosAltos	|
	
@deletePlace @regression	
Scenario: Verify deleteApi deletes existing place
	Given deletePlace Payload
	When user calls "deletePlaceAPI" with "post" http request
	Then api call is success with status code is 200
	And "status" in response Body is "OK"