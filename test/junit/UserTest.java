package junit;

import junit.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by IEvgen Boldyr on 21.06.17.
 */

public class UserTest extends Assert {

    private User user1;
    private User user2;
    private User user3;

    @Before
    public void initialUsers() {
        user1 = new User("test1", "test2");
        user2 = new User("test2", "test3");
        user3 = new User("test2", "test3");
    }

    @Test
    public void testUserEquals() {
        assertTrue("Классы User равны.", user2.equals(user3));
    }

    @Test
    public void testUserNotEquals() {
        assertFalse("Классы User не равны.", user1.equals(user3));
    }

    @Test
    public void testCreateUserNull() {
        assertNull(FactoryUsers.createNull());
    }

    @Test
    public void testCreateUser() {
        User user = null;
        assertNull(user);
        user = FactoryUsers.create("test", "test");
        assertNotNull(user);

        assertEquals("test", user.getLogin());
        assertEquals("test", user.getPassword());
    }

}
