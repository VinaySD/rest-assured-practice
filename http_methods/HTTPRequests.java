package http_methods;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests {

	
	int id;
	
    @Test(priority=1)
    void getUser() 
    {    
        given()
        
        .when()
            .get("https://reqres.in/api/users?page=2")
        
        .then()
            .statusCode(200)
            .body("page", equalTo(2))  
            .log().all();
    }
    
    @Test(priority=2, dependsOnMethods="getUser")
    void createUser()
    {
    	
    	HashMap<String, String> data = new HashMap<>();
    	data.put("name","Vinay");
    	data.put("job","Traniner");
    	
    	id=given()
    	  .contentType("application/json")
    	  .body(data)
    	
    	.when()
    		.post("https://reqres.in/api/users")
    		.jsonPath().getInt("id");
  
    }
    
    @Test(priority=3, dependsOnMethods="createUser")
    void updateUser()
    {
    	HashMap<String, String> data = new HashMap<>();
    	data.put("name","VinaySD");
    	data.put("job","Employee");
    	
    
    	given()
    		.contentType("application/json")
    		.body(data)
    		
    	.when()
			.put("https://reqres.in/api/users/"+id)
			
    	.then()
    		.statusCode(200)
    		.log().all();
    }
    
    
    @Test(priority=4, dependsOnMethods="updateUser")
    void deleteUser()
    {
    	given()
    	
    	.when()
    		.delete("https://reqres.in/api/users/"+id)
    	
    	.then()
    		.statusCode(204);
    }
}
