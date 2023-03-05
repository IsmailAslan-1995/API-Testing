package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C08_Generics {
    @Test
    public void get08(){
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
/* 1. Method
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body( "firstname", Matchers.equalTo("Susan"))
                .body("lastname",Matchers.equalTo("Brown"))
                .body("totalprice",Matchers.greaterThan(500))
                .body("depositpaid",Matchers.equalTo(true))
                .body("bookingdates",Matchers.notNullValue());

 */
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body( "firstname", equalTo("Eric"),
                        "lastname",equalTo("Wilson"),
                        "totalprice",greaterThan(100),
                        "depositpaid",equalTo(false),
                        "bookingdates",notNullValue());
    }
}
