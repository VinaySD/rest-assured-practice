package Diff_Ways_To_Create_Post_Request_Body;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class hash_map {
	
	@Test
	void testPostHasMap(){
		
		HashMap data = new HashMap();
		data.put("name", "Vinay");
		data.put("location","IN");
		data.put("phone", "8546513596");
		
		String courses[] = {"Java", "Python"};
		data.put("courses", courses);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Vinay"))
			.body("location", equalTo("IN"))
			.body("phone", equalTo("8546513596"))
			.body("courses[0]", equalTo("Java"))
			.body("courses[1]", equalTo("Python"))
			.log().all();
	
	}
}
