package parsingjson;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class ParsingJSONResponseData {
	
	//Approach 1
	//@Test
	void testJsonResponseAp1() {
		
		given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/json")
			.body("book[3].title",equalTo("The Lord of the Rings"));
		
	}
	
	//Approach 2
	//@Test
	void testJsonResponseAp2() {
		
		Response res =
				
		given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings"); 
	
	}
	
		//Approach 3
		@Test
		void testJsonResponseAp3() {
			
			Response res =
					
			given()
				.contentType(ContentType.JSON)
				
			.when()
				.get("http://localhost:3000/store");
			
			JSONObject jo = new JSONObject(res.asString());
			
			boolean status = false;
			
			for(int i=0; i< jo.getJSONArray("book").length(); i++) {
				
				String booktitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				
				if(booktitle.equals("The Lord of the Rings")) {
					
					status = true;
					break;
				}
						
		}
			
			Assert.assertEquals(status,true);
	
			//validate the total price'
			
			double totalprice = 0;
			for(int j=0; j< jo.getJSONArray("book").length(); j++) {
				
				String price = jo.getJSONArray("book").getJSONObject(j).get("price").toString();			
				
				totalprice = totalprice+Double.parseDouble(price);
				
			}
			
			System.out.println(totalprice);
			Assert.assertEquals(totalprice, 526.0);
		}
		
}
