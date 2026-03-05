package com.oceanview.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // TC-01
    @Test
    public void testUserDefaultConstructor() {
        User user = new User();
        assertNotNull(user);
    }

    // TC-02
    @Test
    public void testUserGettersAndSetters() {
        User user = new User();
        user.setId(1);
        user.setUsername("testuser");
        user.setPassword("password123");

        assertEquals(1, user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("password123", user.getPassword());
    }

    // TC-03
    @Test
    public void testUserParameterisedConstructor() {
        User user = new User("admin", "admin123");
        assertEquals("admin", user.getUsername());
        assertEquals("admin123", user.getPassword());
    }

    // TC-04
    @Test
    public void testUserSetIdZero() {
        User user = new User();
        user.setId(0);
        assertEquals(0, user.getId());
    }

    // TC-05
    @Test
    public void testUserSetEmptyUsername() {
        User user = new User();
        user.setUsername("");
        assertEquals("", user.getUsername());
    }

    // TC-06
    @Test
    public void testUserSetNullPassword() {
        User user = new User();
        user.setPassword(null);
        assertNull(user.getPassword());
    }
}
