import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class RegisteredUserTester {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UUID userId;
    private boolean isLoggedIn = true;

    @Test
    public void testRegisteredUserConstructor() {
        RegisteredUser u = new RegisteredUser(userId, firstName, lastName, username, password, isLoggedIn);
        assertEquals(u.getId(), userId);
        assertEquals(u.getFirstName(), firstName);
        assertEquals(u.getLastName(), lastName);
        assertEquals(u.getUsername(), username);
        assertEquals(u.getPassword(), password);
        assertEquals(u.getLoggedIn(), isLoggedIn);
    }
}
