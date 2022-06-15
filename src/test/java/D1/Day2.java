package D1;






import io.restassured.*;
import io.restassured.http.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;


public class Day2 {

    @BeforeEach
    public void inti() {
        RestAssured.baseURI = "http://44.201.135.133:8000";
    }

    @Test
    public void test1() {
        assertThat(5+5 , is(10));
        assertThat(3*3,is(9));
        assertThat("Biniyam",equals("Biniyam"));
        assertThat(5+5,not(5));
        assertThat(3,equalTo(6-3));
        assertThat(5,is(not(6)));
        assertThat(6,is(not(equalTo(12))));

    }

    public void test2() {
        String text = "Api course";
        assertThat(text,is("Api course"));
        assertThat(text,is(not("food")));
        assertThat(text,not("Biniyam"));
        assertThat(text,startsWith("Ap"));
        assertThat(text,endsWith("se"));
        assertThat(text, containsString("course"));

    }

    
}
