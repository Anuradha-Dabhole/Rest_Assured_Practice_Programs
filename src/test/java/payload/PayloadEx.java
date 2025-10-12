package payload;

public class PayloadEx {
	
	//---this Post example body----
public static String Addemp(String name,String job) {
		String empbody="{\r\n"//\r\n adds a newline (carriage return + line feed) — this just formats the string perfectly a.
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return empbody;
}
//----this is library body---
public static String getBookDetails(String isbn,int aisle)
{
	String BookDetails="{\r\n"
			+ "\r\n"
			+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
			+ "\"isbn\":\""+isbn+"\",\r\n"
			+ "\"aisle\":\""+aisle+"\",\r\n"
			+ "\"author\":\"John foe\"\r\n"
			+ "}\r\n"
			+ " \r\n"
			+ "";
	return BookDetails;
}
public static String getBookDetails1(String bookname ,String isbn,String aisle)
{
	String BookDetails="{\r\n"
			+ "\r\n"
			+ "\"name\":\""+bookname+"\",\r\n"
			+ "\"isbn\":\""+isbn+"\",\r\n"
			+ "\"aisle\":\""+aisle+"\",\r\n"
			+ "\"author\":\"John foe\"\r\n"
			+ "}\r\n"
			+ " \r\n"
			+ "";
	return BookDetails;
}
//------Gorestexample----
public static String Gorestpayload()
{
	String payload="{\"name\":\"Tenali Ramakrishna\", \r\n"
			+ "\"gender\":\"male\", \r\n"
			+ "\"email\":\"tenali.palluwe@"+Math.random()+"15ce.com\",\r\n"
			+ " \"status\":\"active\"}";
	return payload;
}

}
 