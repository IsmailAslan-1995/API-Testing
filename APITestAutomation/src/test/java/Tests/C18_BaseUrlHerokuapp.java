package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlHerokuapp extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        specHerokuapp.pathParam("pp1","booking");
        Response response=given().when().spec(specHerokuapp).get("/{pp1}");
        JsonPath responseJsonPath=response.jsonPath();
        System.out.println(responseJsonPath.getList("bookingid").size() );;
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(8783));

    }
}
