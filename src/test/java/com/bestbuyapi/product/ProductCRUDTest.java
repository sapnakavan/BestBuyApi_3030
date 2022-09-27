package com.bestbuyapi.product;


import com.bestbuyapi.model.ProductPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductCRUDTest extends TestBase {


    @Test// get full list
    public void test001() {
        Response response=given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }



    @Test// post new data and retrive id
    public void test002() {

        ProductPojo productPojo = new ProductPojo();



        productPojo.setName("Dyson");
        productPojo.setType("Vaccum");
        productPojo.setPrice(9.8f);
        productPojo.setUpc("041333436757");
        productPojo.setShipping(567);
        productPojo.setDescription("Power Preserve technology");
        productPojo.setManufacturer("dyson");
        productPojo.setModel("MN1300R4Z");

        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }



    @Test// update data with id
    public void test003() {
        ProductPojo productPojo =new ProductPojo();
        productPojo.setName("Altoe");
        productPojo.setType("automatic");

        Response response=given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .pathParam("id","9999712")
                .body(productPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }



    @Test // delete above id
    public void test004() {
        Response response=given()
                .basePath("/products")
                .pathParam("id","312290")
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }



    @Test // retrieve id and validate id has delete
    public void test005() {
        Response response=given()
                .basePath("/products")
                .pathParam("id","312290")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }

    }



