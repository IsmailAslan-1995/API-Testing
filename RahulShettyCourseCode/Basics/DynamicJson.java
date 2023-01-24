package Dynamic;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider = "BookData")
    public void addBok(String isbn,String aisle){
        RestAssured.baseURI="http://216.10.245.166";
        String response=given().log().all().header("Content-Type","application/json")
                .body(payload.addBook(isbn,aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jsonPath= ReUsableMethods.rawToJson(response);
        String id=jsonPath.get("ID");
        System.out.println(id);

    }
    @DataProvider(name = "BookData")
    public Object[][] getData(){

        return new Object[][]{{"isdfg","1"},{"dsfg","2"},{"dsfgh","3"}};
    }
}

