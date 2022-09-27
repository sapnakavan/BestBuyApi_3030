package com.bestbuyapi.stores;

import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreGetTest extends TestBase {
    @Test
    public void getallstoreinfo() {
        Response response = given()
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getsinglestoreinfo(){
        Response response = given()
                .basePath("/stores")
                .pathParam("id","6")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
