package com.bestbuyapi.stores;

import com.bestbuyapi.model.ProductPojo;
import com.bestbuyapi.model.StorePojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreCurdTest extends TestBase {

    @Test
    public void Test1() {
        Response response = given()
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void Test2(){
        Response response = given()
                .basePath("/stores")
                .pathParam("id","6")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Test3(){
        StorePojo storePojo = new StorePojo();

        storePojo.setName("Tedbaker1");
        storePojo.setType("Clothing2");
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
    @Test
    public void Test4()
    { StorePojo storePojo = new StorePojo();

        storePojo.setName("matalan");
        storePojo.setType("Clothings");


        Response response = given()
                .basePath("/stores")
                .header("Content-Type","application/json")
                .pathParam("id","6")
                .body(storePojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void Test5(){
        Response response=given()
                .basePath("/stores")
                .pathParam("id","4")
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }
    @Test
    public void Test6(){
        Response response = given()
                .basePath("/stores")
                .pathParam("id","4")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }
}
