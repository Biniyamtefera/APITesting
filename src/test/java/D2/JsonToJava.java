package D2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utility.SpartanTestBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonToJava extends SpartanTestBase {
    //response body to map

    @Test
    public void responseMap() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("api/spartans/110");

        response.prettyPrint();

        Map<String, Object> responseMap = response.as(Map.class);
        System.out.println(responseMap);

        System.out.println("responseMap.get(\"id\") = " + responseMap.get("id"));
        System.out.println("responseMap.get(\"name\") = " + responseMap.get("name"));
        System.out.println("responseMap.get(\"phone\") = " + responseMap.get("phone"));

    }
    //response to list
    @Test
    public void responseList() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("api/spartans");

        //response.prettyPrint();

        List<Map<String,Object>> responseList = response.as(List.class);
        //System.out.println("responseList = " + responseList);

        //How can we get specific, like Id for number 20 from the list
        Map<String, Object> myList1 = responseList.get(19);
        System.out.println(myList1.get("id"));
        System.out.println(myList1.get("name"));
        System.out.println(myList1.get("phone"));


    }

}
