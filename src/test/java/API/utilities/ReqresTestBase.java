package API.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class ReqresTestBase {

    @BeforeAll
    public static void init() {
        //save baseurl in this variable so we don t need to type each http method
       RestAssured.baseURI = "https://reqres.in/";
    }

    @AfterAll
    public static void teardown() {

    }
}
