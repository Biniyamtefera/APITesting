package utility;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class SpartanTestBase {
    @BeforeEach
    public void init() {

        RestAssured.baseURI = "http://44.201.135.133:8000";
    }
}
