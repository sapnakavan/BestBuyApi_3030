package com.bestbuyapi.stores;

import com.bestbuyapi.model.StorePojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePostTest extends TestBase {
    @Test
    public void createnewstore(){
        StorePojo storePojo = new StorePojo();

        storePojo.setName("Tedbaker");
        storePojo.setType("Clothing");
        storePojo.setAddress("22 Drive Court");
        storePojo.setAdd2("edgware");
        storePojo.setCity("Mopkins");
        storePojo.setState("MN");
        storePojo.setZip("45805");
        storePojo.setLat(44.568923);
        storePojo.setLang(93.456892);
        storePojo.setHouurs("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .basePath("/stores")
                .header("Content-Type","application/json")
                .body(storePojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
