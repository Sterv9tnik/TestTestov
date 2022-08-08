package tests.api;

import api.UsersApi;
import api.models.getUser.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettingUserTest {

    @Test
    public void checkingGetUser() {
        int userId = 2;
        String email = "janet.weaver@reqres.in";
        String firstName = "Janet";
        String lastName = "Weaver";
        String avatar = "https://reqres.in/img/faces/2-image.jpg";

        User user = UsersApi.getUserSuccess(userId);

        assertEquals(user.getData().getAvatar(), avatar);
        assertEquals(user.getData().getEmail(), email);
        assertEquals(user.getData().getId(), userId);
        assertEquals(user.getData().getFirstName(), firstName);
        assertEquals(user.getData().getLastName(), lastName);
    }

    @Test
    public void checkingGetUserFail() {
        int userId = 23;
        UsersApi.getUserFail(userId);
    }

    @Test
    public void checkingGetUsers() {
        UsersApi.getUsers(1, 12);
    }
}
