package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_CreateJsonObject {
    @Test
    public void get04(){
        JSONObject dateJsonObject=new JSONObject();
        dateJsonObject.put("checkin","2018-01-01");
        dateJsonObject.put("checkout","2018-01-03");

        JSONObject requestBody=new JSONObject();
        requestBody.put("firstname","İsmail");
        requestBody.put("additionalneeds","Breakfast");
        requestBody.put("bookingdates",dateJsonObject);
        requestBody.put("totalprice",111);
        requestBody.put("depositpaid",true);
        requestBody.put("lastname","ASLAN");
        System.out.println(requestBody);

    }
}
