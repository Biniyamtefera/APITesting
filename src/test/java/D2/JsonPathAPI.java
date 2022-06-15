package D2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utility.SpartanTestBase;

public class JsonPathAPI extends SpartanTestBase {

    @DisplayName("Using JsonPath")
    @Test
    public void test1 () {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/");
        response.prettyPrint();

        JsonPath jsonpath = response.jsonPath();

        String name = jsonpath.getString("name");
        Long phoneNumber = jsonpath.getLong("phone");
        String gender = jsonpath.getString("gender");

        System.out.println(name);
        //System.out.println("Phonenumber = "  + phoneNumber);
        //System.out.println("gender = " + gender);


    }
}
