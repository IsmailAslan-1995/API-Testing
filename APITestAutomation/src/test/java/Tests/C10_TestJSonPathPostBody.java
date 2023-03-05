package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_TestJSonPathPostBody {
    @Test
    public void get10(){
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

        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("İsmail"),
                        "booking.lastname",equalTo("ASLAN"),
                         "booking.depositpaid",equalTo(false),
                         "booking.totalprice",equalTo(500),
                         "booking.bookingdates.checkin",equalTo("2023-01-01"),
                         "booking.bookingdates.checkout",equalTo("2023-01-18"));
    }
}
