package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataHerokuapp;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C25_TestDataClassUsage extends BaseUrlHerokuapp {
    @Test
    public void test() {

        specHerokuapp.pathParam("pp1","booking");

        JSONObject requestBody= TestDataHerokuapp.createJsonRequestBody
                ("Jim","Brown",111, true,"2018-01-01","2019-01-01","Breakfast");
        JSONObject expectedData=TestDataHerokuapp.createJsonResponseBody ("Jim","Brown",111, true,"2018-01-01","2019-01-01","Breakfast");

        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(requestBody.toString()).post("/{pp1}");

        JsonPath responseJsonPath=response.jsonPath();


        assertEquals(expectedData.getJSONObject("booking").getString("firstname"),responseJsonPath.getString("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getString("lastname"),responseJsonPath.getString("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice"),responseJsonPath.getInt("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid"),responseJsonPath.getBoolean("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"),responseJsonPath.getString("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"),
                responseJsonPath.getString("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"),
                responseJsonPath.getString("booking.bookingdates.checkout"));




    }



}
