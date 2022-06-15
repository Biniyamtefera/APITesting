package D2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExample {

    @BeforeEach

    public void init() {
        RestAssured.baseURI = "http://44.201.135.133:8000";
    }

    @Test
    public void assertNumber() {
        assertThat(5+5, is(10));
        assertThat(3*3, not(10));
        assertThat(9,is(not(10)));
        assertThat(4,equalTo(2*2));
        assertThat(9,is(not(equalTo(8))));
    }

    @Test
    public void assertString() {
        String text = "Food is good";
        assertThat("Biniyam", is("Biniyam"));
        assertThat(text, startsWith("Foo"));
        assertThat(text, endsWith("od"));
        assertThat(text,containsString("is"));
        assertThat(text, equalTo("Food is good"));
        assertThat(text, is(not("Biniyam")));
        assertThat(text,is("Food is good"));
        assertThat(text,not("Redu"));
    }
    @Test
    public void assertList() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        assertThat(list,hasItem(6));
        assertThat(list,hasSize(9));
        assertThat(list,everyItem(lessThan(10)));
    }

    @Test
    public void assertResponse() {
        RestAssured.given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 107)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .assertThat()
                .body("id", is(107),
                        "name",is("Mac"));
    }

}
