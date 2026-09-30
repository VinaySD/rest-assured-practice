package Diff_Ways_To_Create_Post_Request_Body;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class usingPOJO {
	
	@Test
	void testPostPOJO() {
		
		POJO data = new POJO();
		data.setName("Ichigo");
		data.setLocation("Japan");
		data.setPhone("01574684");
		
		String coursesArr[] = {"RestAPI","Machine Learning"};
		data.setCourses(coursesArr);
		
		
		given()
		.contentType("application/json")
		.body(data)
	
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Ichigo"))
		.body("location", equalTo("Japan"))
		.body("phone", equalTo("01574684"))
		.body("courses[0]", equalTo("RestAPI"))
		.body("courses[1]", equalTo("Machine Learning"))
		.log().all();
	}
}
