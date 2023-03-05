package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlJsonPlaceholderRestapi extends BaseUrlJsonPlaceholder {

    @Test
    public void test01(){
        specJsonPlaceholder.pathParam("pp1","posts");
        Response response=given().when().spec(specJsonPlaceholder).get("/{pp1}");
        response.then().assertThat().statusCode(200).body("id",Matchers.hasSize(100));

    }
    @Test
    public void test02(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",44);
        Response response=given().when().spec(specJsonPlaceholder).get("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
    @Test
    public void test03(){
        specJsonPlaceholder.pathParams("pp1","posts","pp2",50);
        Response response=given().when().spec(specJsonPlaceholder).delete("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title", Matchers.nullValue());
    }
}
