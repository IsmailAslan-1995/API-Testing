package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class C13_CreateExpectedBody {
    @Test
    public void get13(){
        String url="https://jsonplaceholder.typicode.com/posts/2";

        JSONObject expectedData=new JSONObject();
        expectedData.put("id", 2);
        expectedData.put("userId", 1);
        expectedData.put("title", "qui est esse");
        expectedData.put(    "body", "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla");

        Response response=given().when().get(url);
        JsonPath responseJsonPath=response.jsonPath();
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));



    }
}
