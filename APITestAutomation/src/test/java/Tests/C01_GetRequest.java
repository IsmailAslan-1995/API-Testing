package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest {
    @Test
    public void get01(){
        // Request body ve end-point hazırlama
        String url="https://restful-booker.herokuapp.com/booking/10";
        // Expected data hazırlama
        // Request gönderip, dönen response u kaydetme
        Response response=given().when().get(url);
        response.prettyPrint();
        //Assertion
    }
}
