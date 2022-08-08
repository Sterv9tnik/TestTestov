package tests.api;

import api.UsersApi;
import api.models.createUser.CreateUserData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreatingUserTest {

    @Test
    public void checkingCreateUser() {
        String name = "Alexey Besedin";
        String job = "QA engineer";

        CreateUserData createUserData = new CreateUserData(name, job);
        CreateUserData actualCreateUserData = UsersApi.createUserSuccess(createUserData);

        assertEquals(name, actualCreateUserData.getName());
        assertEquals(job, actualCreateUserData.getJob());
    }

//    @Test
    public void failCreateUserWithoutBody() {
        UsersApi.createUserFail();
    }

    @Test
    public void failCreateUser() {
        int name = 10;
        int job = 10;
        UsersApi.createUserFail(name, job);
    }
}
