package com.bestbuyapi.stores;

import com.bestbuyapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreDeleteTest extends TestBase {
    @Test
    public void delete(){
        Response response=given()
                .basePath("/stores")
                .pathParam("id","4")
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }
}
