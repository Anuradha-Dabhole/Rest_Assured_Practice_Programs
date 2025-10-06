package payload;

public class PayloadEx {
public static String Addemp(String name,String job) {
		String empbody="{\r\n"//\r\n adds a newline (carriage return + line feed) — this just formats the string perfectly a.
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return empbody;
}

}
