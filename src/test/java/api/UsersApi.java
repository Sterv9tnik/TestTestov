package api;

import api.models.createUser.CreateUserData;
import api.models.getUser.User;

import static api.SpecHelper.getRequestSpec;
import static api.SpecHelper.getResponseSpec;
import static api.endpoints.UsersEndpoints.USER;
import static api.endpoints.UsersEndpoints.USERS;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class UsersApi {

    public static User getUserSuccess(int userId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .get(String.format(USER.getUrl(), userId))
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(User.class);
    }

    public static void getUserFail(int userId) {
        given()
                .spec(getRequestSpec())
                .when()
                .get(String.format(USER.getUrl(), userId))
                .then()
                .spec(getResponseSpec(SC_NOT_FOUND));
    }

    public static CreateUserData createUserSuccess(CreateUserData createUserData) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(createUserData)
                .post(USERS.getUrl())
                .then()
                .spec(getResponseSpec(SC_CREATED))
                .extract()
                .as(CreateUserData.class);
    }

    public static void createUserFail(int name, int job) {
        given()
                .spec(getRequestSpec())
                .when()
                .body(String.format("{'name': '%s', 'job': '%s';}", name, job))
                .post(USERS.getUrl())
                .then()
                .spec(getResponseSpec(SC_BAD_REQUEST));
    }

    public static void createUserFail() {
        given()
                .spec(getRequestSpec())
                .when()
                .post(USERS.getUrl())
                .then()
                .spec(getResponseSpec(SC_BAD_REQUEST));
    }

    public static void getUsers(int page, int perPage) {
        given()
                .spec(getRequestSpec())
                .when()
                .queryParam("page", page)
                .queryParam("per_page", perPage)
                .get(USERS.getUrl())
                .then()
                .spec(getResponseSpec(SC_OK));
    }
}
