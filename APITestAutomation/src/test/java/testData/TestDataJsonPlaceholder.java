package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestDataJsonPlaceholder {
    public static int successStatusCode=200;
    public static String contentType="application/json; charset=utf-8";
    public static String headerConnection="keep-alive";
    public static JSONObject createResponseBody21(){

        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

        return expectedData;
    }
    public static JSONObject createJsonBody(int userId, int id, String title, String body){
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body",body);

        return expectedData;
    }
    public static Map<String, Object> createMapBody(Object title,Object body, Object userId,Object id){
        Map<String,Object> mapBody=new HashMap<>();
        mapBody.put("title",title);
        mapBody.put("body",body);
        mapBody.put("userId",userId);
        mapBody.put("id",id);

        return mapBody;

    }
}
