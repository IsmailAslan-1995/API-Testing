package tests;

import baseUrl.BaseUrlDummySampleRestApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataDummyExample;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C24_TestDataClassUsage extends BaseUrlDummySampleRestApi {
    @Test
    public void test(){

        //endpoint and request body

        specDummyExample.pathParams("pp1","employee","pp2",1);
        // expected data
        JSONObject expectedData= TestDataDummyExample.createJsonBody
                (1,"Tiger Nixon","320800","61","");

        //send request and save response
        Response response=given().spec(specDummyExample).when().get("/{pp1}/{pp2}");
        JsonPath responseJsonPath=response.jsonPath();

        //Assertion
        assertEquals(TestDataDummyExample.successStatusCode,response.statusCode());
        assertEquals(TestDataDummyExample.contentType,response.contentType());
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),responseJsonPath.getString("data.profile_image"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),responseJsonPath.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_salary"),responseJsonPath.getString("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_age"),responseJsonPath.getString("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getInt("id"),responseJsonPath.getInt("data.id"));
        assertEquals(expectedData.getString("message"),responseJsonPath.getString("message"));
        assertEquals(expectedData.getString("status"),responseJsonPath.getString("status"));

    }
}
