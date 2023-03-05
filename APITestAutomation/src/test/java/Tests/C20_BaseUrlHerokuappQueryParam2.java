package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuappQueryParam2 extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        specHerokuapp.pathParam("pp1","booking").queryParams("firstname","Susan","lastname","Ericson");
        Response response=given().when().spec(specHerokuapp).get("/{pp1}");
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(1));

    }

}
