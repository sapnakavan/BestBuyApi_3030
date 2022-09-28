package com.bestbuyapi.stores;

import com.bestbuyapi.model.ProductPojo;
import com.bestbuyapi.model.StorePojo;
import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePatchTest extends TestBase {
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

}
