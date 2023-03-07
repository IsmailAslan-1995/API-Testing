package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataDummyExample {
    public static int successStatusCode=200;
    public static String contentTypeShort="application/json";
    public static String contentType="application/json; charset=utf-8";
    public static JSONObject createJsonBody(int id,String employee_name,String employee_salary,String employee_age,String profile_image){

        JSONObject responseBody=new JSONObject();
        JSONObject dataBody=new JSONObject();
        dataBody.put("id",id);
        dataBody.put("employee_name",employee_name);
        dataBody.put("employee_salary",employee_salary);
        dataBody.put("employee_age",employee_age);
        dataBody.put("profile_image",profile_image);
        responseBody.put("status","success");
        responseBody.put("data",dataBody);
        responseBody.put("message","Successfully! Record has been fetched.");

        return responseBody;

    }
    public static Map<String,Object> createMapBody(double id, String employee_name, double employee_salary, double employee_age, String profile_image){

        Map<String,Object> mapBody=new HashMap<>();
        Map<String,Object> mapData=new HashMap<>();
        mapData.put("id",id);
        mapData.put("employee_name",employee_name);
        mapData.put("employee_salary",employee_salary);
        mapData.put("employee_age",employee_age);
        mapData.put("profile_image",profile_image);
        mapBody.put("status","success");
        mapBody.put("data",mapData);
        mapBody.put("message","Successfully! Record has been fetched.");

        return mapBody;

    }


}
