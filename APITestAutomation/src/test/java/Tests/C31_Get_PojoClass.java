package tests;

import baseUrl.BaseUrlDummySampleRestApi;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoDummySampleRestApi;
import pojos.PojoDummySampleRestApiData;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C31_Get_PojoClass extends BaseUrlDummySampleRestApi {
    @Test
    public void test(){
        //end point and request body
        specDummyExample.pathParams("pp1","employee","pp2","3");
        //expected Data
        PojoDummySampleRestApiData dataPojo=new PojoDummySampleRestApiData(3,"Ashton Cox",86000, 66,"");
        PojoDummySampleRestApi expectedDataPojo=new PojoDummySampleRestApi("success",dataPojo,"Successfully! Record has been fetched.");

        // send request and save response
        Response response=given().spec(specDummyExample).when().get("/{pp1}/{pp2}");

        PojoDummySampleRestApi responsePojo=response.as(PojoDummySampleRestApi.class);

        //Assertion

        assertEquals(expectedDataPojo.getStatus(),responsePojo.getStatus());
        assertEquals(expectedDataPojo.getMessage(),responsePojo.getMessage());

        assertEquals(expectedDataPojo.getData().getEmployee_name(),responsePojo.getData().getEmployee_name());
        assertEquals(expectedDataPojo.getData().getId(),responsePojo.getData().getId());
        assertEquals(expectedDataPojo.getData().getEmployee_age(),responsePojo.getData().getEmployee_age());
        assertEquals(expectedDataPojo.getData().getEmployee_salary(),responsePojo.getData().getEmployee_salary());
        assertEquals(expectedDataPojo.getData().getProfile_image(),responsePojo.getData().getProfile_image());






    }
}
