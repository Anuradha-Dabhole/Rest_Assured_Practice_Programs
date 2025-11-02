package mypractice1;
import org.testng.Assert;

import MockResponse.CourceDetails;
import io.restassured.path.json.JsonPath;

public class HandlingmcokJson {

	public static void main(String[] args) {
JsonPath js= new JsonPath(CourceDetails.getcoursedetails());

//print number of cources returned by API
int coursesize=js.getInt("courses.size()");
System.out.println("The total courses are:" +coursesize);

//print the purchase amount
int purchaseamount =js.getInt("dashboard.purchaseAmount");
System.out.println("The purchase amount are:"+purchaseamount);

//print the title of
String firsttitle=js.get("courses[0].title");
System.out.println("The first title is:"+firsttitle);


//print all cource title and respective price

System.out.println("all cource title and respective price");
for(int i=0;i<coursesize;i++)
{
	String coursestitle=js.getString("courses["+i+"].title");
	int respectiveprice=js.getInt("courses["+i+"].price");
	System.out.println(coursestitle +" "+respectiveprice);
	
	
}

//print the copies sold by RPA courses

String courseRPA=js.getString("courses[2].copies");
System.out.println("copies of RPA course:"+courseRPA);

//verify if sum of all course price matches with purchase amount
int sum=0;
for(int i=0;i<coursesize;i++)
{
	int totalprice=js.getInt("courses["+i+"].price");
	int totalcopies=js.getInt("courses["+i+"].copies");
	int amount=totalprice*totalcopies;
	sum=sum+amount;
	
	
			
}
System.out.println("Total sum is"+sum);

Assert.assertEquals(sum, purchaseamount);

System.out.println("My test case passed!!");
	}

}
