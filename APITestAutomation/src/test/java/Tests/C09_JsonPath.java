package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C09_JsonPath {
    @Test
    public void get09(){
        JSONObject personalInfo=new JSONObject();
        JSONObject addressInfo=new JSONObject();
        JSONArray phoneInfo=new JSONArray();
        JSONObject mobilePhone=new JSONObject();
        JSONObject homePhone=new JSONObject();

        addressInfo.put("streetAddress","naist street");
        addressInfo.put("city","Nara");
        addressInfo.put("postalCode","630-0192");

        mobilePhone.put("type","iPhone");
        mobilePhone.put("number","0123-1524-2525");
        homePhone.put("type","home");
        homePhone.put("number","0123-4100-1905");
        phoneInfo.put(mobilePhone);
        phoneInfo.put(homePhone);

        personalInfo.put("firstname","İsmail");
        personalInfo.put("lastname","ASLAN");
        personalInfo.put("age",25);
        personalInfo.put("address",addressInfo);
        personalInfo.put("phoneNumbers",phoneInfo);
        System.out.println(personalInfo.get("firstname"));
        System.out.println(personalInfo.getJSONObject("address").get("streetAddress"));
        System.out.println(personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));





    }
}
