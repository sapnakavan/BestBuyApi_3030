package com.bestbuyapi.product;


import com.bestbuyapi.model.ProductPojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductPatchTest extends TestBase {

    @Test
    public void updateProductWithPatch(){
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
}
