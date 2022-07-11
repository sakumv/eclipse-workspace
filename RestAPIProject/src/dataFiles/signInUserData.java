package dataFiles;

public class signInUserData {
	public static String signInStudent()
	{
		//Give the User name and password for signing in
		String det =  "{\r\n"
				+ "  \"email\": \"saku.jay@gmail.com\",\r\n"
				+ "  \"password\": \"12345Abc\"\r\n"
				+ "}";
		return det;
	}
	public static String signInTeacher()
	{
		//Give the User name and password for signing in
		String det =  "{\r\n"
				+ "  \"email\": \"sakumv@gmail.com\",\r\n"
				+ "  \"password\": \"12345Abc\"\r\n"
				+ "}";
		return det;
	}	
	public static String signInDetails(String email, String pwd)
	{
		//Give the User name and password for signing in
		String det =  "{\r\n"
				+ "  \"email\": \""+ email +"\",\r\n"
				+ "  \"password\": \""+ pwd +"\"\r\n"
				+ "}";
		return det;
	}	

}
