package com.bestbuyapi.stores;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Extract {

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

    //1. Extract the limit
    @Test
    public void limit() {
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //2. Extract the total
    @Test
    public void total() {
        int total = response.extract().path("total");
        System.out.println("The total is : " + total);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void nameof5thstore() {
        String name = response.extract().path("data[4].name");
        System.out.println("The name of 5th store : " + name);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void nameofallstore() {
        List<String> names = response.extract().path("data.name");
        System.out.println("All stores : " + names);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void nameofallstoreid() {
        List<Integer> noofid = response.extract().path("data.id");
        System.out.println("Name of All store id  : " + noofid);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void sizeofdata() {
        List<Integer> datsSize = response.extract().path("data");
        int sizes = datsSize.size();
        System.out.println("The size of the data is : " + sizes);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void stcloud() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("The values for product name St Cloud' are: " + values);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }


    //8. Get the address of the store where store name = Rochester
    @Test
    public void addressofrochester() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("The store address are: " + address);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }


    //9. Get all the services of 8th store
    @Test
    public void servicesof8thstore() {
        List<HashMap<String, Object>> services = response.extract().path("data[7].services");
        System.out.println("Services of 8th stores are : ");
        for (HashMap<String, Object> service : services) {
            System.out.println(service);
            System.out.println("----------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------");
        }
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void windowstore() {
        List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.storeservices");
        System.out.println("Storeservices created are: " + services);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void allthestoreid() {

        List<HashMap<String, Object>> storeid = response.extract().path("data.services.storeservices.storeId");
        System.out.println("The store id is: " + storeid);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }
    //12. Get id of all the store

    @Test
    public void allstore() {

        List<Integer> idList = response.extract().path("data.id");
        System.out.println("List of Ids are : " + idList);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void storename() {
        List<String> state = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("List of Ids are : " + state);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test0014() {
        int total = response.extract().path("data[8].services.size");
        List<String> services = response.extract().path("data.findAll{it.name=='Rochester'}.services");
        System.out.println("List of services are : " + services);
        System.out.println("List of Total services are : " + total);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void allwindowsstore() {
        List<HashMap<String, Object>> created = response.extract().path("data.services[5].createdAt");
        System.out.println("The createdAt services are: " + created);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void fargo() {
        List<String> services = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("The store name are: " + services);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void zipallstore() {
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println("Zip list are: " + zip);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void ziproseville() {

        List<Integer> zip = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("Zip for the store are: " + zip);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void storeservice() {
        List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.name=='Magnolia Home Theater'}.services");
        System.out.println("services detail are: " + services);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void latofstore() {
        List<Double> lat = response.extract().path("data.lat");
        System.out.println("The store lat are: " + lat);
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }
}