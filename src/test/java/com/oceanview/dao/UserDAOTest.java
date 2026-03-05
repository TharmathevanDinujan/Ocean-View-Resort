package com.oceanview.dao;

import com.oceanview.model.User;
import com.oceanview.util.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserDAOTest {

    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    private MockedStatic<DBConnection> mockedDBConnection;
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        mockedDBConnection = mockStatic(DBConnection.class);
        mockedDBConnection.when(DBConnection::getConnection).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        userDAO = new UserDAO();
    }

    @AfterEach
    public void tearDown() {
        if (mockedDBConnection != null)
            mockedDBConnection.close();
    }

    // TC-18
    @Test
    public void testAuthenticateSuccess() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("username")).thenReturn("admin");
        when(mockResultSet.getString("password")).thenReturn("admin123");

        User user = userDAO.authenticate("admin", "admin123");
        assertNotNull(user);
        assertEquals("admin", user.getUsername());
        assertEquals("admin123", user.getPassword());
    }

    // TC-19
    @Test
    public void testAuthenticateFailure() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        User user = userDAO.authenticate("admin", "wrongpassword");
        assertNull(user);
    }

    // TC-20
    @Test
    public void testAuthenticateSetsParam1() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        userDAO.authenticate("admin", "admin123");
        verify(mockPreparedStatement).setString(1, "admin");
    }

    // TC-21
    @Test
    public void testAuthenticateSetsParam2() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        userDAO.authenticate("admin", "admin123");
        verify(mockPreparedStatement).setString(2, "admin123");
    }

    // TC-22
    @Test
    public void testAuthenticateCallsExecuteQuery() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        userDAO.authenticate("admin", "admin123");
        verify(mockPreparedStatement, times(1)).executeQuery();
    }
}
