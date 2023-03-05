package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_HardAssertion {
    @Test
    public void get14(){
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody=new JSONObject();
        JSONObject reservationDate=new JSONObject();

        reservationDate.put("checkin","2023-01-01");
        reservationDate.put("checkout","2023-01-18");
        requestBody.put("firstname","İsmail");
        requestBody.put("lastname","ASLAN");
        requestBody.put("additionalneeds","Breakfast");
        requestBody.put("bookingdates",reservationDate);
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);


        JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",requestBody);

        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);

        JsonPath responseJsonPath=response.jsonPath();
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),responseJsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responseJsonPath.get("booking.bookingdates.checkout"));


    }
}
