package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;

public class C21_TestDataClassUsage extends BaseUrlJsonPlaceholder {
    @Test
    public void test01(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",22);
        JSONObject expectedData= TestDataJsonPlaceholder.createResponseBody21();
        Response response=given().when().spec(specJsonPlaceholder).get("/{pp1}/{pp2}");
        JsonPath responseJsonAPth=response.jsonPath();
        Assert.assertEquals(TestDataJsonPlaceholder.successStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonAPth.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonAPth.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonAPth.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonAPth.getString("body"));





    }
}
