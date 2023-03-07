package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class C28_Post_DeSerialization extends BaseUrlHerokuapp {
    @Test
    public void test(){
        //endpoint and requestBody
        specHerokuapp.pathParam("pp1","booking");
        Map<String,Object> requestBodyMap= TestDataHerokuapp.createMapRequestBody  ("Jim","Brown",111, true,"Breakfast","2018-01-01","2019-01-01");

        //expected Data
        Map<String,Object> expectedData=TestDataHerokuapp.createMapResponse(25,"Jim","Brown",111, true,"Breakfast","2018-01-01","2019-01-01");

        //send request and save response
        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(requestBodyMap).post("/{pp1}");
        Map<String,Object> responseMap=response.as(HashMap.class);

        //Assertion
        assertEquals(((Map)expectedData.get("booking")).get("firstname"),((Map)responseMap.get("booking")).get("firstname"));
        assertEquals(((Map)expectedData.get("booking")).get("lastname"),((Map)responseMap.get("booking")).get("lastname"));
        assertEquals(((Map)expectedData.get("booking")).get("totalprice"),((Map)responseMap.get("booking")).get("totalprice"));
        assertEquals(((Map)expectedData.get("booking")).get("additionalneeds"),((Map)responseMap.get("booking")).get("additionalneeds"));
        assertEquals(((Map)expectedData.get("booking")).get("depositpaid"),((Map)responseMap.get("booking")).get("depositpaid"));

        assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkin"),
                ((Map)((Map) responseMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map) responseMap.get("booking")).get("bookingdates")).get("checkout"));



    }
}
