package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C22_TestDataClassUsage extends BaseUrlJsonPlaceholder {
    @Test
    public void test01(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",40);
        JSONObject expectedData= TestDataJsonPlaceholder.createResponseJsonBody(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\n" +
                "ipsum rem optio mollitia quas\n" +
                "voluptatem eum voluptas qui\n" +
                "unde omnis voluptatem iure quasi maxime voluptas nam");
        Response response=given().when().spec(specJsonPlaceholder).get("/{pp1}/{pp2}");
        JsonPath responseJsonAPth=response.jsonPath();
        assertEquals(TestDataJsonPlaceholder.successStatusCode,response.statusCode());
        assertEquals(expectedData.getInt("userId"),responseJsonAPth.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonAPth.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonAPth.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonAPth.getString("body"));





    }
}
