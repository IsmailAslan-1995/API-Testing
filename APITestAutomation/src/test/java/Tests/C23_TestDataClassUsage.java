package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C23_TestDataClassUsage extends BaseUrlJsonPlaceholder {
    @Test
    public void test(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);
        JSONObject requestBody= TestDataJsonPlaceholder.createJsonBody(10,70,"Ismail","Inar Academy");
        JSONObject expectedData=TestDataJsonPlaceholder.createJsonBody(10,70,"Ismail","Inar Academy");
        Response response=given().spec(specJsonPlaceholder).contentType(ContentType.JSON).when().body(requestBody.toString()).put("/{pp1}/{pp2}");

        JsonPath responseJsonPath=response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.successStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));


    }
}
