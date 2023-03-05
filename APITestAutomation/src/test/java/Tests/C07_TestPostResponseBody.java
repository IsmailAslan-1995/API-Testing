package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

public class C07_TestPostResponseBody {
    @Test
    public void get07(){
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody=new JSONObject();
        requestBody.put("title","API");
        requestBody.put("body","API candir");
        requestBody.put("userId",25);

        Response response=given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString()).post(url);
        response.then().assertThat().statusCode(201).contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("body",Matchers.containsString("API"))
                .body("userId",Matchers.lessThan(100));

    }
}
