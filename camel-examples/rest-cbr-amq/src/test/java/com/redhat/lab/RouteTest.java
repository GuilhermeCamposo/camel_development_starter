package com.redhat.lab;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.xml.XmlPath;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Assertions;

@QuarkusTest
public class RouteTest {

    @Test
    void testTransformation() throws Exception{

      XmlPath response =   
         
        given()    
            .header("Content-Type", "application/xml")
            .body(RouteTest.class.getResourceAsStream("/sample-body.xml"))
        .when()
            .post("/transform")
        .then()
            .statusCode(200)
            .extract().body().htmlPath();

      String name = response.getString("items.item[0].title");

      Assertions.assertEquals("Lord of The Rings", name);

    }
    
}
