package com.bestbuyapi.product;


import com.bestbuyapi.model.ProductPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductPostTest extends TestBase {

    @Test
    public void createProduct() {


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

    }



