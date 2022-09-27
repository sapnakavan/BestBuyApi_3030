package com.bestbuyapi.stores;

import com.bestbuyapi.testbase.TestBase;
import groovy.lang.DelegatesTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;

public class Assert {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    //1. Verify the if the total is equal to 1571
    @Test
    public void verifytotal(){
        response.body("total",equalTo(1571));
    }

    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void verifylimit() {
        response.body("limit", equalTo(10));
    }

    //3. Check the single ‘Name’ in the Array list (Fitbit  Watch)
    @Test
    public void verifyname() {
        response.body("data.name", hasItem("Fitbit  Watch"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Minnetonka, Lenovo, Northtown)
    @Test
    public void verifymultiplename(){
        response.body("data.name", hasItems("Minnetonka", "Lenovo", "Northtown"));
    }

    //5. Verify the storied=11 inside storeservices of the third store of second services
    @Test
    public void verifystoreid(){
        response.body("data[2].services[1].storeservices",hasKey("storeId"));
    }

    //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Northtown

    @Test
    public void verifycreatedat(){
        response.body("data[2].services[0]",hasKey("createdAt"));
    }

    //7. Verify the state = MN of forth store
    @Test
    public  void  verifystate(){
       response.body("data[3].state",equalTo("MN"));
    }

    //8. Verify the store name = La Crosse of 9 th store
    @Test
    public  void  verifyname1(){
        response.body("data[8].name",equalTo("La Crosse"));
    }


    //9. Verify the storeId = 14 for the 6th store
    @Test
    public void verifystoreid1(){
        response.body("data[5].services[0].storeservices",hasKey("storeId"));
    }


    //10. Verify the serviceId = 4 for the 7 th store of forth service
    @Test
    public void verifyserviceid(){
        response.body("data[6].services[3].storeservices",hasKey("serviceId"));
    }


}
