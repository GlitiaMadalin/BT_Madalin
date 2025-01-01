package API.FunctionalTestsApi;

import API.utilities.ReqresTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class FunctionalTest extends ReqresTestBase {

    private static int employeeID;


    /*
    Given accept type is application/json
    When User sends get request to "/api/users?page=2"
    Then
         response status code must be 200
         content type is ContentType
         verify Data has values
         in body id is 7
         in body first_name is Michael
         in body last_name is Lawson
         email is "https://reqres.in/img/faces/7-image.jpg"
     */
    @Test
    public void getAllUsersPaged() {
        given().accept(ContentType.JSON)
                .when().get("/api/users?page=2").prettyPeek().
                then()
                .statusCode(200)
                .contentType(ContentType.JSON.toString())
                .header("Date", notNullValue())
                .body("data[0].id", is(7))
                .body("data[0].first_name", is("Michael"))
                .body("data[0].last_name", is("Lawson"))
                .body("data[0].avatar", is("https://reqres.in/img/faces/7-image.jpg"));
    }

    /*
   Given accept type is application/json
   When User sends get request to "/api/users?delay=3"
   Then
        response status code must be 200
        content type is ContentType
        id is 1
        in body first_name is George
        in body last_name is Bluth
        email is "https://reqres.in/img/faces/1-image.jpg"
    */
    @Test
    public void getAllUsersPageDisplay() {
        given().accept(ContentType.JSON)
                .when().get("/api/users?delay=3").prettyPeek().
                then()
                .statusCode(200)
                .contentType(ContentType.JSON.toString())
                .body("data[0].id", is(1))
                .body("data[0].first_name", is("George"))
                .body("data[0].last_name", is("Bluth"))
                .body("data[0].avatar", is("https://reqres.in/img/faces/1-image.jpg"))
        ;
    }

    /*
   Given accept type is application/json
   When User sends get request to "/api/users/2"
   Then
        rasponse status code must be 200
        content type is ContentType
        verify Data has values
        in body first_name is Janet
        in body last_name is Weaver
        email is "https://reqres.in/img/faces/2-image.jpg"
    */
    @Test
    public void getOnlyOneUsers() {
        given().accept(ContentType.JSON)
                .when().get("/api/users/2").prettyPeek().
                then()
                .statusCode(200)
                // .contentType(ContentType.JSON.toString())
                .header("Date", notNullValue())
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"))
                .body("data.avatar", is("https://reqres.in/img/faces/2-image.jpg"));
    }

    /*
  Given accept type is application/json
  And token is "QpwL5tke4Pnpja7X4"
  When User sends get request to "/api/users/2"
  And  content type is "application/json"
  Then
       rasponse status code must be 200
       content type is ContentType
       in body first_name is 4
       in body token is "QpwL5tke4Pnpja7X4"
   */
    @Test
    public void postRegisterUser() {
        Map<String, Object> employeeMap = new LinkedHashMap<>();
        employeeMap.put("email", "eve.holt@reqres.in");
        employeeMap.put("password", "pistol");

        System.out.println(employeeMap);

        String employeeID = given().accept(ContentType.JSON)
                .contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/register").prettyPeek().
                then().
                statusCode(200)
                .contentType("application/json")
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"))
                .extract().jsonPath().getString("id");

        System.out.println(employeeID + " is generated");
    }

    /*
    Given accept type is application/json
    And "email" as "sydney@fife"
    When User sends get request to "/api/users/2"
    And  content type is "application/json"
    Then
         rasponse status code must be 400
         content type is ContentType
         in body "error" is "Missing password"
     */
    @Test
    public void postPostRegisterUserUnssuccesful() {
        Map<String, Object> employeeMap = new LinkedHashMap<>();
        employeeMap.put("email", "sydney@fife");

        System.out.println(employeeMap);

        String message = given().accept(ContentType.JSON)
                .contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/register").prettyPeek().
                then().
                statusCode(400)
                .contentType("application/json")
                .body("error", is("Missing password"))
                .extract().jsonPath().getString("error");

        System.out.println(message + " is generated");
    }

    @Test
    public void getApiSingleUserNotFound() {
        given().
                when()
                .get("/api/unknown/23").
                then().
                statusCode(404);
    }

    @Test
    public void getApiUnknown() {
        given().
                when()
                .get("/api/unknown").
                then().
                statusCode(200)
                .body("data[0].id", is(1))
                .body("data[0].name", is("cerulean"))
                .body("data[0].year", is(2000))
                .body("data[0].color", is("#98B2D1"))
                .body("data[0].pantone_value", is("15-4020"));
    }

    @Test
    public void getApiSingleOnlyUnknown() {
        given().
                when()
                .get("/api/unknown/2").
                then().
                statusCode(200)
                .body("data.id", is(2))
                .body("data.name", is("fuchsia rose"))
                .body("data.year", is(2001))
                .body("data.color", is("#C74375"))
                .body("data.pantone_value", is("17-2031"));
    }

    @Test
    public void getApiSingleOnlyUnknownNotFound() {
        given().
                when()
                .get("/api/unknown/23").
                then().
                statusCode(404);
    }

    /*
    Given accept type is application/json
    And "name" is "morpheus"
    And "job" is "leader"
    When User sends get request to "/api/users"
    And  content type is "application/json"
    Then
         rasponse status code must be 201
         content type is ContentType
         "error" is "Missing password"
         in body "name", is "morpheus"
         in body "job", is "leader"
         */

    @Test
    public void postCreate() {
        Map<String, Object> employeeMap = new LinkedHashMap<>();
        employeeMap.put("name", "morpheus");
        employeeMap.put("job", "leader");

        System.out.println(employeeMap);

        Response post = given().accept(ContentType.JSON)
                .contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/users");

        String employeeID = given().accept(ContentType.JSON)
                .contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/users").prettyPeek().
                then().
                statusCode(201)
                .contentType("application/json")
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .extract().jsonPath().getString("id");

        System.out.println(employeeID + " is generated");
    }

    /*
        Given accept type is application/json
        And "name" is "morpheus"
        And "job" is "zion resident"
        When User sends get request to "/api/users"
        And  content type is "application/json"
        Then
             rasponse status code must be 200
             content type is ContentType
             "error" is "Missing password"
             in body "name", is "morpheus"
             in body "job", is "zion resident"
         */
    @Test
    public void putUpdate() {
        Map<String, Object> employeeMap = new LinkedHashMap<>();
        employeeMap.put("name", "morpheus");
        employeeMap.put("job", "zion resident");

        String employeeID = given().contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/users/2").prettyPeek().
                then().
                statusCode(201)
                .contentType("application/json")
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .extract().jsonPath().getString("id");

        System.out.println(employeeID + " is generated");
    }

    /*
          Given accept type is application/json
          And "name" is "morpheus"
          And "job" is "zion resident"
          When User sends get request to "/api/users"
          And  content type is "application/json"
          Then
               rasponse status code must be 200
               content type is ContentType
               "error" is "Missing password"
               in body "name", is "morpheus"
               in body "job", is "zion resident"
     */
    @Test
    public void patch() {
        Map<String, Object> employeeMap = new LinkedHashMap<>();
        employeeMap.put("name", "morpheus");
        employeeMap.put("job", "zion resident");

        System.out.println(employeeMap);

        Response post = given().contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/users/2");

        String employeeID = given().contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/users/2").prettyPeek().
                then().
                statusCode(201)
                .contentType("application/json")
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .extract().jsonPath().getString("id");

        System.out.println(employeeID + " is generated");
    }


    /*
            When User sends get request to "/api/users"
            Then
                rasponse status code must be 200
         */
    @Test
    public void delete() {
        given().
                when()
                .delete("/api/unknown/2").
                then().
                statusCode(204);
    }

    /*
               Given accept type is application/json
               And "name" is "morpheus"
               And "job" is "zion resident"
               When User sends get request to "/api/users"
               And  content type is "application/json"
               Then
                    rasponse status code must be 200
                    content type is ContentType
                    "error" is "Missing password"
                    in body "token"is "QpwL5tke4Pnpja7X4"))
         */
    @Test
    public void loginSuccesful() {
        Map<String, Object> employeeMap = new LinkedHashMap<>();
        employeeMap.put("email", "eve.holt@reqres.in");
        employeeMap.put("password", "cityslicka");

        System.out.println(employeeMap);

        Response post = given().contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/login");

        String token = given().contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/login").prettyPeek().
                then().
                statusCode(200)
                .contentType("application/json")
                .body("token", is("QpwL5tke4Pnpja7X4"))
                .extract().jsonPath().getString("token");

        System.out.println(token + " is generated");
    }


    /*
           Given accept type is application/json
           When User sends get request to "/api/login"
           And  content type is "application/json"
           Then
                rasponse status code must be 400
                content type is ContentType
                in body "error", is "QpwL5tke4Pnpja7X4"
     */
    @Test
    public void testLoginUnsuccesfull() {
        Map<String, Object> employeeMap = new LinkedHashMap<>();
        employeeMap.put("email", "peter@klaven");

        System.out.println(employeeMap);

        String message = given().contentType("application/json")
                .body(employeeMap).
                when()
                .post("/api/login").prettyPeek().
                then().
                statusCode(400)
                .contentType("application/json")
                .body("error", is("Missing password"))
                .extract().jsonPath().getString("error");

        System.out.println(message + " is generated");
    }
}
