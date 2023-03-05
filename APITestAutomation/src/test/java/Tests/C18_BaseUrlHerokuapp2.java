package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody=new JSONObject();
        JSONObject reservationDate=new JSONObject();
        reservationDate.put("checkin","2021-06-01");
        reservationDate.put("checkout","2021-06-10");

        requestBody.put("firstname","İsmail");
        requestBody.put("lastname","ASLAN");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",true);
        requestBody.put("bookingdates",reservationDate);
        requestBody.put("additionalneeds","breakfast");

        Response response=given().contentType(ContentType.JSON)
                .when().spec(specHerokuapp).body(requestBody.toString()).post("/{pp1}");

        response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("İsmail"));

    }
}
