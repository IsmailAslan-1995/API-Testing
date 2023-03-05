package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_GetRequestSoftAssertion {
    @Test
    public void get15(){
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        JSONObject expectedData=new JSONObject();
        JSONObject dataInfoJson=new JSONObject();

        //expected data
        dataInfoJson.put("id",3);
        dataInfoJson.put("employee_name","Ashton Cox");
        dataInfoJson.put("employee_salary",86000);
        dataInfoJson.put("employee_age",66);
        dataInfoJson.put("profile_image","");

        expectedData.put("status","success");
        expectedData.put("data",dataInfoJson);
        expectedData.put("message","Successfully! Record has been fetched.");

        Response response=given().when().get(url);
        JsonPath responseJsonPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.id"),expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),expectedData.getJSONObject("data").get("profile_image"));
        softAssert.assertAll();







    }
}
