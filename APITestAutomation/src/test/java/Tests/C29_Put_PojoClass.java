package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoJsonPlaceholder;
import testData.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C29_Put_PojoClass extends BaseUrlJsonPlaceholder {
    @Test
    public void test(){
        //endpoint and request body
        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        PojoJsonPlaceholder requestBodyPojo=new PojoJsonPlaceholder("İsmail","ASLAN",25,70);

        // expected Data
        PojoJsonPlaceholder expectedDataPojo=new PojoJsonPlaceholder("İsmail","ASLAN",25,70);

        // send request and save response
        Response response=given().spec(specJsonPlaceholder).contentType(ContentType.JSON).when().body(requestBodyPojo).put("/{pp1}/{pp2}");

        PojoJsonPlaceholder responsePojo=response.as(PojoJsonPlaceholder.class);

        assertEquals(TestDataJsonPlaceholder.successStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());





    }
}
