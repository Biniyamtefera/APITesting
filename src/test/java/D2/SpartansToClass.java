package D2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utility.SpartanTestBase;

public class SpartansToClass extends SpartanTestBase {

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("api/spartans/160");

        response.prettyPrint();
    }
}
