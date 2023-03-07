package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {
    public static int successStatusCode=200;
    public static String contentType="application/json; charset=utf-8";

    public static JSONObject createJsonRequestBody(String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout, String additionalneeds) {

        JSONObject requestBody=new JSONObject();
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin",checkin);
        bookingDates.put("checkout",checkout);

        requestBody.put("firstname",firstname);
        requestBody.put("lastname",lastname);
        requestBody.put("totalprice",totalprice);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("additionalneeds",additionalneeds);

        return requestBody;
    }
    public static JSONObject createJsonResponseBody(String firstname, String lastname, int totalprice, boolean depositpaid, String checkin, String checkout, String additionalneeds){
        JSONObject responseBody=new JSONObject();
        JSONObject bookingBody=TestDataHerokuapp.createJsonRequestBody
                (firstname,lastname,totalprice,depositpaid,checkin,checkout,additionalneeds);
        responseBody.put("bookingid",1);
        responseBody.put("booking",bookingBody);
        return responseBody;
    }
    public static Map<String,Object> createMapRequestBody(String firstname, String lastname, double totalprice, boolean depositpaid, String additionalneeds,String checkin, String checkout) {

        Map<String,Object> requestBody=new HashMap<>();

        requestBody.put("firstname",firstname);
        requestBody.put("lastname",lastname);
        requestBody.put("totalprice",totalprice);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("additionalneeds",additionalneeds);
        requestBody.put("bookingdates",createMapBookingBody(checkin,checkout));

        return requestBody;
    }
    public static Map<String,String> createMapBookingBody(String checkin, String checkout) {

        Map<String,String> bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);

        return bookingDatesMap;

    }
    public static Map<String,Object> createMapResponse(double bookingid,String firstname, String lastname, double totalprice, boolean depositpaid, String additionalneeds,String checkin, String checkout){
        Map<String,Object> responseBodyMap=new HashMap<>();
        responseBodyMap.put("bookingid",bookingid);
        responseBodyMap.put("booking",createMapRequestBody(firstname,lastname,totalprice,depositpaid,additionalneeds,checkin,checkout));
        return responseBodyMap;

    }

}