package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class C05_Put_ResponseAssertion {
    @Test
    public void get05(){
        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject requestBody=new JSONObject();
        requestBody.put("title","İsmail");
        requestBody.put("body","Merhaba");
        requestBody.put("userID",10);
        requestBody.put("id",125);

        Response response=given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString()).put(url);

         response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                                    .header("Server","cloudflare").statusLine("HTTP/1.1 200 OK");



    }
}
