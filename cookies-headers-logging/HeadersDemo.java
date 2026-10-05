package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class HeadersDemo {
	
	//@Test(priority=1)
	void testHeaders() {
		
		given()
		
		.when()
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding","text/html; charset=ISO-8859-1")
			.header("Server", "gws");	
	}
	
	@Test(priority=2)
	void getHeaderInfo() {
		
		Response res = given()
				
				.when()
					.get("https://www.google.com/");
				
				//get single cookie info
				
				 //String header_value = res.getHeader("Content-Type");
				 //System.out.println("Value of cookies is == " +  header_value);
				
				
				//get all cookies info
				
				Headers myheaders =  res.getHeaders();
				
				for(Header header : myheaders) {
					
					System.out.println(header.getName()+"           "+header.getValue());
				}
	}
}
