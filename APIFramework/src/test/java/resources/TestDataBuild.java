package resources;

import java.util.Arrays;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	public AddPlace addPlacePayload(String name, String language, String address)
	{
		AddPlace ap = new AddPlace();
		Location ln = new Location();
		ln.setLat(-38.383494);
		ln.setLng(33.427362);
		ap.setAccuracy(50);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setLocation(ln);
		ap.setName(name);
		ap.setPhone_number("1-408-996-2031");
		String[] ls = {"Bangle Park","shop"};
		List<String> al = Arrays.asList(ls);
		ap.setTypes(al);
		ap.setWebsite("http://www.test.com"); 
		
		return ap;
	}

	public String deletePlacePayload(String place_id)
	{
		String esp_json = "{\r\n    \"place_id\":\""+ place_id +"\"\r\n}";
		return esp_json;
	}
	
	
	
}
