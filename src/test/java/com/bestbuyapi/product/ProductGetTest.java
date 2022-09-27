package com.bestbuyapi.product;


import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductGetTest extends TestBase {

    @Test
    public void getAllProductsInfo() {
        Response response=given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProductInfo() {

        Response response=given()
                .basePath("/products")
            .pathParam("id","312290")
            .when()
            .get("/{id}");
    response.then().statusCode(200);
    response.prettyPrint();
    }




}
