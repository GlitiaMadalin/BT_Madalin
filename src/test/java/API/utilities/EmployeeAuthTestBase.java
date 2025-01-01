package API.utilities;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class EmployeeAuthTestBase {

    @BeforeAll
    public static void init(){

    }

    @AfterAll
    public static void destroy(){

        reset();
    }

    public static RequestSpecification reqSpec(String username, String password){
        return given().accept(ContentType.JSON)
                .auth().basic(username, password);
    }

    public static ResponseSpecification resSpec(int statusCode){
        return expect().contentType(ContentType.JSON).
                statusCode(statusCode);
    }
}
