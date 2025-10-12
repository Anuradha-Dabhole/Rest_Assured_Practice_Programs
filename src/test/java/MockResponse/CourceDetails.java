package MockResponse;

public class CourceDetails {

public static String getcoursedetails()
{
	String Respayload=" {\r\n"
			+ "\"dashboard\" : {\r\n"
			+ "\r\n"
			+ "\"purchaseAmount\": 635,\r\n"
			+ "\r\n"
			+ "\"website\": \"groskillIT.com\"\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "\"courses\": [\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"Selenium Python\",\r\n"
			+ "\r\n"
			+ "\"price\": 50,\r\n"
			+ "\r\n"
			+ "\"copies\": 4\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"Cypress\",\r\n"
			+ "\r\n"
			+ "\"price\": 40,\r\n"
			+ "\r\n"
			+ "\"copies\": 3\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "{\r\n"
			+ "\r\n"
			+ "\"title\": \"RPS\",\r\n"
			+ "\r\n"
			+ "\"price\": 45,\r\n"
			+ "\r\n"
			+ "\"copies\": 7\r\n"
			+ "\r\n"
			+ "}\r\n"
			+ "] \r\n"
			+ "}\r\n"
			+ "}";
	return Respayload;
}

}
