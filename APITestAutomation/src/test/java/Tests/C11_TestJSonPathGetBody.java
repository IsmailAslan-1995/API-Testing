package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class C11_TestJSonPathGetBody {
    @Test
    public void get11(){
        String url="http://dummy.restapiexample.com/api/v1/employees";
        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("data.id",hasSize(24),"data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,21,35));

    }
}
