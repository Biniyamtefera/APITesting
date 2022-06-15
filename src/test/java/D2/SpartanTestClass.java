package D2;

import D2.POJO.Search;
import D2.POJO.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utility.SpartanTestBase;

public class SpartanTestClass extends SpartanTestBase {

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("api/spartans/160");
        //response.prettyPrint();

        Spartan spartan160 = response.as(Spartan.class);
        System.out.println("spartan160 = " + spartan160);
        System.out.println("spartan160 = " + spartan160.toString());

    }

    @Test
    public void responseList() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("api/spartans");

        JsonPath jsonPath = response.jsonPath();
       // System.out.println("jsonPath.getList(\"\") = " + jsonPath.getList(""));

        Spartan spartan = jsonPath.getObject("[1]", Spartan.class);
        System.out.println("spartan = " + spartan);
        System.out.println("spartan.toString() = " + spartan.toString());

        //ctrl + D
    }

    //getting list response
    @Test
    public void ListResponseInQueryParameter() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender", "Female")
                .get("api/spartans/search");
        response.prettyPrint();
    }

    //use the spartan list pojo class

    @Test
    public void spartanSearchClass() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().queryParam("gender", "Female")
                .get("api/spartans/search");
        //response.prettyPrint();

        Search searchFemale = response.as(Search.class);
        System.out.println("searchFemale = " + searchFemale);
    }

    @Test
    public void getRegionHR() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("http://44.201.135.133:1000/ords/hr/regions");

        response.prettyPrint();

    }
}
