package tests;

import baseUrl.BaseUrlDummySampleRestApi;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataDummyExample;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class C27_Get_DeSerialization extends BaseUrlDummySampleRestApi {
    @Test

    public void test(){
        //endpoint and requestBody
        specDummyExample.pathParams("pp1","employee","pp2",3);
        //expected Data
        Map<String, Object> expectedData= TestDataDummyExample.createMapBody
                (3.0,"Ashton Cox",86000.0,66.0,"");



        // send request and save response
        Response response=given().spec(specDummyExample).when().get("/{pp1}/{pp2}");
        response.prettyPrint();
        Map<String,Object> responseMap=response.as(HashMap.class);

        //Assertion
        assertEquals(TestDataDummyExample.successStatusCode,response.statusCode());
        assertEquals(TestDataDummyExample.contentTypeShort,response.contentType());

        assertEquals(expectedData.get("message"),responseMap.get("message"));
        assertEquals(expectedData.get("status"),responseMap.get("status"));
        assertEquals(((Map)expectedData.get("data")).get("profile_image"),((Map)responseMap.get("data")).get("profile_image"));
        assertEquals(((Map)expectedData.get("data")).get("employee_name"),((Map)responseMap.get("data")).get("employee_name"));
        assertEquals(((Map)expectedData.get("data")).get("employee_salary"),((Map)responseMap.get("data")).get("employee_salary"));
        assertEquals(((Map)expectedData.get("data")).get("employee_age"),((Map)responseMap.get("data")).get("employee_age"));
        assertEquals(((Map)expectedData.get("data")).get("id"),((Map)responseMap.get("data")).get("id"));




    }
}
