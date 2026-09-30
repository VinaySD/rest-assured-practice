package Diff_Ways_To_Create_Post_Request_Body;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class externalJSON {
	
	@Test
	void testPostExternalJSON() throws FileNotFoundException {
		
		File file = new File(".\\body.json");
		
		FileReader fr = new FileReader(file);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
			
		given()
		.contentType("application/json")
		.body(data.toString())
	
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Libert"))
		.body("location", equalTo("Germany"))
		.body("phone", equalTo("35687451"))
		.body("courses[0]", equalTo("Go"))
		.body("courses[1]", equalTo("Deep Learning"))
		.log().all();
	}
}
