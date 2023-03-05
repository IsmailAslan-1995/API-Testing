package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;


public class C16_PutRequestSoftAssert {
    @Test
    public void get16(){
        String url="http://dummy.restapiexample.com/api/v1/update/21";
        JSONObject requestBody=new JSONObject();
        JSONObject dataInfoJson=new JSONObject();

        //expected data
        dataInfoJson.put("id",40);
        dataInfoJson.put("name","Ashton Cox");
        dataInfoJson.put("salary","1230");
        dataInfoJson.put("age","44");

        requestBody.put("status","success");
        requestBody.put("data",dataInfoJson);

        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully! Record has been fetched.");

        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).put(url);
        JsonPath responseJsonPath=response.jsonPath();
        response.prettyPrint();


        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.status"),expectedData.getJSONObject("data").get("status"));
        softAssert.assertEquals(responseJsonPath.get("data.data.name"),expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.data.id"),expectedData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),expectedData.getJSONObject("data").getJSONObject("data").get("salary"));

        softAssert.assertAll();



    }
}
