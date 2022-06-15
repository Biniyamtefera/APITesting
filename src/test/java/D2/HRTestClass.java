package D2;

import D2.POJO.GetItems;
import D2.POJO.Items;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utility.HRTestBase;

public class HRTestClass extends HRTestBase {
    @Test
    public void getRegionHR() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/ords/hr/regions");

       // response.prettyPrint();

        Items items1 = response.as(Items.class);
        System.out.println("items = " + items1);

        System.out.println("items1.getLinks() = " + items1.getLinks());



    }

    @Test
    public void getSpecificRegion() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("/ords/hr/regions");

        // response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        GetItems region = jsonPath.getObject("items[0]", GetItems.class);
        System.out.println("region = " + region);

    }
}

