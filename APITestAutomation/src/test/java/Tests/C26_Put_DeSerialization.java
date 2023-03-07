package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataJsonPlaceholder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class C26_Put_DeSerialization extends BaseUrlJsonPlaceholder {
    @Test
    public void test(){
        //Endpoint and request body
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        Map<String, Object> requestMap= TestDataJsonPlaceholder.createMapBody("İsmail","Merhaba",25.0,70.0);

        //Expected data
        Map<String, Object> expectedData= TestDataJsonPlaceholder.createMapBody("İsmail","Merhaba",25.0,70.0);

        Response response=given().spec(specJsonPlaceholder).contentType(ContentType.JSON).when().body(requestMap).put("/{pp1}/{pp2}");


        //response convert to map for assertion
        Map<String,Object> responseMap=response.as(HashMap.class);
        assertEquals(expectedData.get("title"),responseMap.get("title"));
        assertEquals(expectedData.get("body"),responseMap.get("body"));
        assertEquals(expectedData.get("userId"),responseMap.get("userId"));
        assertEquals(expectedData.get("id"),responseMap.get("id"));




    }
}
