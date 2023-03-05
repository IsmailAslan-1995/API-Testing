package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_getRequest {
    @Test
    public void get02(){
        // Request body ve end-point hazırlama
        String url="https://restful-booker.herokuapp.com/booking/10";
        // Expected data hazırlama
        // Request gönderip, dönen response u kaydetme
        Response response=given().when().get(url);
        System.out.println(" status code : "+response.getStatusCode()+
                "\n Content Type : "+response.getContentType()+
                "\n Server Header : "+response.getHeader("Server")+
                "\n Status Line : "+ response.getStatusLine()+
                "\n Response time : "+response.getTime()+"ms");
        //Assertion
    }
}
