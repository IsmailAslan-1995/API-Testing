package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoHerokuappBookingDates;
import pojos.PojoHerokuappRequestBody;
import pojos.PojoHerokuappResponseBody;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C30_Post_PojoClass extends BaseUrlHerokuapp {
    @Test
    public void test(){
        //endpoint and requestbody
        specHerokuapp.pathParam("pp1","booking");
        PojoHerokuappBookingDates bookingDates=new PojoHerokuappBookingDates("2021-01-12","2021-01-21");
        PojoHerokuappRequestBody requestBody=new PojoHerokuappRequestBody("İsmail","ASLAN",25000,true,bookingDates,"wi-fi");

        //expectedData
        bookingDates=new PojoHerokuappBookingDates("2021-01-12","2021-01-21");

        PojoHerokuappRequestBody bookingPojo=new PojoHerokuappRequestBody("İsmail","ASLAN",25000,true,bookingDates,"wi-fi");
        PojoHerokuappResponseBody expectedData=new PojoHerokuappResponseBody(25,bookingPojo);

        //send request and save response
        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(requestBody).post("/{pp1}");

       PojoHerokuappResponseBody responsePojo=response.as(PojoHerokuappResponseBody.class);

       //Assertion
        assertEquals(expectedData.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedData.getBooking().getLastname(),responsePojo.getBooking().getLastname());
        assertEquals(expectedData.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());
        assertEquals(expectedData.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedData.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());
        assertEquals(expectedData.getBooking().getBookingDates().getCheckin(),responsePojo.getBooking().getBookingDates().getCheckin());
        assertEquals(expectedData.getBooking().getBookingDates().getCheckout(),responsePojo.getBooking().getBookingDates().getCheckout());




    }
}
