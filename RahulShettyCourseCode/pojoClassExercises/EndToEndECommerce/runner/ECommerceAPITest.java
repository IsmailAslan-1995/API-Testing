package pojoExercise;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.OrderDetails;
import pojo.Orders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {
    public static void main(String[] args) {

                                //Login
        RequestSpecification loginBaseReq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setUserEmail("ben123@gmail.com");
        loginRequest.setUserPassword("Gs190525");
        RequestSpecification requestLogin=given().relaxedHTTPSValidation().log().all().spec(loginBaseReq).body(loginRequest);
        LoginResponse loginResponse=requestLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
        System.out.println(loginResponse.getMessage());
        String token=loginResponse.getToken();
        String userId=loginResponse.getUserId();

                                //Create Product

        RequestSpecification createProductBaseReq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization",token).build();
        RequestSpecification reqAddProduct = given().log().all().spec(createProductBaseReq).param("productName", "Laptop")
                .param("productAddedBy", userId).param("productCategory", "fashion")
                .param("productSubCategory", "shirts").param("productPrice", "11500")
                .param("productDescription", "Lenova").param("productFor", "men")
                .multiPart("productImage",new File("C:\\Users\\Sys\\Desktop\\indir.png"));
        String addProductResponse=reqAddProduct.when().post("/api/ecom/product/add-product").then().log().all().extract().response().asString();
        JsonPath jsonPath=new JsonPath(addProductResponse);
        String productId=jsonPath.get("productId");
                                //Create Order
        RequestSpecification createOrderBaseReq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization",token).setContentType(ContentType.JSON).build();

        OrderDetails orderDetails=new OrderDetails();
        orderDetails.setCountry("Turkey");
        List<OrderDetails> orderDetailsList=new ArrayList<>();
        orderDetailsList.add(orderDetails);
        orderDetails.setProductOrderId(productId);
        Orders orders=new Orders();
        orders.setOrders(orderDetailsList);

       RequestSpecification createOrderReq=given().log().all().spec(createOrderBaseReq).body(orders);
       String responseCreateOrder=createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
       System.out.println(responseCreateOrder);
                                 //Delete Product
        RequestSpecification deleteProductBaseReq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization",token).setContentType(ContentType.JSON).build();
        RequestSpecification deleteProductReq=given().log().all().spec(deleteProductBaseReq).pathParam("productId",productId);
       String deleteProductResponse= deleteProductReq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().extract().response().asString();
        JsonPath js=new JsonPath(deleteProductResponse);
        String message=js.get("message");
        Assert.assertEquals("Product Deleted Successfully",message);





    }
}

