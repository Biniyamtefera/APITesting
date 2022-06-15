package D1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Day1 {
           @BeforeEach
             public void inti() {
               RestAssured.baseURI = "http://44.201.135.133:8000";
           }

    String baseUrl = "http://44.201.135.133:8000";
    @Test
    public void test1() {
          String url = "http://44.201.135.133:8000/api/spartans";

          Response response = RestAssured.given().accept(ContentType.JSON)
                  .get(url);

          response.prettyPrint();
        System.out.println(response.statusCode());
        Assertions.assertEquals(22, response.statusCode());
    }

    @Test
    public void test2() {
        String url = "http://44.201.135.133:8000/api/spartans";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .get(url);
        System.out.println("response.getHeaders().toString() = " + response.getHeaders().toString());
        Assertions.assertEquals("application/json",response.contentType());
        Assertions.assertEquals("keep-alive", response.getHeader("Connection"));
        Assertions.assertEquals("timeout=60", response.getHeader("Keep-Alive"));

    }

    @Test
    public void xmlResponse() {
        String url = "http://44.201.135.133:8000/api/spartans";

        Response response = RestAssured.given().accept(ContentType.XML)
                .get(url);
        System.out.println("response.getHeaders().toString() = " + response.getHeaders().toString());
        Assertions.assertEquals("application/json",response.contentType());
        Assertions.assertEquals("keep-alive", response.getHeader("Connection"));
        Assertions.assertEquals("timeout=60", response.getHeader("Keep-Alive"));

    }

    @Test
    public void baseUrlUsage() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get(baseUrl + "/api/spartans" );
        Assertions.assertEquals(200,response.statusCode());
        System.out.println(response.statusCode());
    }

    //get body information

    @Test
    public void beforeAnnotationExample() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/api/spartans/107" );
       // System.out.println("response.prettyPrint() = " + response.prettyPrint());
       // System.out.println("response.path(\"name\").toString() = " + response.path("name").toString());
        //System.out.println("response.path(\"gender\").toString() = " + response.path("gender").toString());

        Assertions.assertEquals("Zulfikar", response.path("name"));
        Assertions.assertEquals("Male", response.path("gender"));

    }

    //providing id in path form
    @Test
    public void pathParameterExample() {
        Response response = RestAssured.given().accept(ContentType.JSON).when()
                .pathParam("id", 107).when()
                .get("/api/spartans/{id}");
        response.prettyPrint();
        Assertions.assertEquals("Zulfikar", response.path("name"));
        Assertions.assertEquals("Male", response.path("gender"));
    }

    //Query Parameter

    @Test
    public void QueryParameterExample() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .queryParam("gender", "Female").when()
                .get("/api/spartans/search");

        response.prettyPrint();
        System.out.println("Name contains ae********************");
        Response responseContain= RestAssured.given().accept(ContentType.JSON)
                .when()
                .queryParam("nameContains", "ar").when()
                .get("/api/spartans/search");
        responseContain.prettyPrint();

        System.out.println("*****Mixed query parametr*********");

        System.out.println("Name contains ae********************");
        Response responseContainMix= RestAssured.given().accept(ContentType.JSON)
                .when()
                .queryParam("nameContains", "ar").when()
                .queryParam("gender", "Female")
                .get("/api/spartans/search");
        responseContainMix.prettyPrint();
    }

    //insteade of providing a number of query parameter we can provide once
    @Test
    public void mixedQuery() {
        System.out.println("*****Bunch of querry parameter*****");
        Map<String,Object> queryParams = new HashMap<>();
        queryParams.put("Gender", "Female");
        queryParams.put("nameContains", "ar");

        Response responseMap = RestAssured.given().accept(ContentType.JSON).when()
                .queryParams(queryParams)
                .when().get("/api/spartans/search");

        responseMap.prettyPrint();

    }

    //Post request
    @Test
    public void postExample() {

        String newSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"ReduCake\",\n" +
                "  \"phone\": 1231231232\n" +
                "}";
        Response response = RestAssured.given().accept(ContentType.JSON).when()
                .and()
                .contentType(ContentType.JSON)
                .body(newSpartan)
                .when().post("/api/spartans");


        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();

        Assertions.assertEquals("A Spartan is Born!", response.path("success" ));

    }

    @Test
    public void updateSpartan() {
        String updateSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"ReduAndMimiCake\",\n" +
                "  \"phone\": 1231231232\n" +
                "}";
        Response response = RestAssured.given().accept(ContentType.JSON).when()
                .and()
                .contentType(ContentType.JSON)
                .body(updateSpartan)
                .when().put("/api/spartans/490");
        response.prettyPrint();
    }
    //We can also provide the id in the path parameter

    @Test
    public void updateSpartanUsingPath() {
        String updateSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"MekdMimiCake\",\n" +
                "  \"phone\": 1231231232\n" +
                "}";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(updateSpartan)
                .pathParams("id", 490)
                .when().put("/api/spartans/{id}");

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
        Assertions.assertEquals(204, response.statusCode());

    }

    @Test
    public void deleteExample () {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 490)
                .when().delete("/api/spartans/{id}");

        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
        //Assertions.assertFalse("Not pass",204, response.statusCode());
    }
}
