package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.security.AccountManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AccountManagerTest{
    @InjectMocks
    AccountManager accountManager = new AccountManager();

    public void testAuthorize() throws Exception {
    }

    @Test
    public void testIsAuthorized() throws Exception {
        HttpSession session = Mockito.mock(HttpSession.class);
        User user = createUser("f1", "l1");
        Mockito.when(session.getAttribute("User")).thenReturn(user).thenReturn(null);

        assertEquals(accountManager.isAuthorized(session), true);
        assertEquals(accountManager.isAuthorized(session), false);

    }

    public void testLogOffUserFromSession() throws Exception {

    }

    User createUser(String firstName, String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;

    }
}