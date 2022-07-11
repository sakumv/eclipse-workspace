package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@deletePlace")
	public void runAddBeforeDelete() throws IOException
	{
		//write a code to get place id
		//execute this only when place_id is null
			
		
		if (stepDefinition.place_id == null)
		{
			stepDefinition sd = new stepDefinition();
		
			sd.add_place_payload_with("Getta", "Roman", "Romania");
			sd.user_calls_with_post_http_request("addPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("Getta", "getPlaceAPI");
		}
		
	}
	
	
}
