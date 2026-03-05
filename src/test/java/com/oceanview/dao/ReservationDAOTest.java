package com.oceanview.dao;

import com.oceanview.model.Reservation;
import com.oceanview.util.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ReservationDAOTest {

    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    private MockedStatic<DBConnection> mockedDBConnection;
    private ReservationDAO reservationDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        mockedDBConnection = mockStatic(DBConnection.class);
        mockedDBConnection.when(DBConnection::getConnection).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        reservationDAO = new ReservationDAO();
    }

    @AfterEach
    public void tearDown() {
        if (mockedDBConnection != null)
            mockedDBConnection.close();
    }

    // TC-23: insert executes update and binds res_number
    @Test
    public void testInsertReservation() throws SQLException {
        Reservation res = new Reservation("R-101", "Bob Maker", "123 Street",
                "555-1234", "Suite", LocalDate.now(), LocalDate.now().plusDays(2), 500.0);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        reservationDAO.insertReservation(res);

        verify(mockPreparedStatement).setString(1, "R-101");
        verify(mockPreparedStatement).executeUpdate();
    }

    // TC-24: insert binds guest name at index 2
    @Test
    public void testInsertReservationGuestName() throws SQLException {
        Reservation res = new Reservation("R-102", "Bob Maker", "123 Street",
                "555-1234", "Suite", LocalDate.now(), LocalDate.now().plusDays(2), 500.0);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        reservationDAO.insertReservation(res);
        verify(mockPreparedStatement).setString(2, "Bob Maker");
    }

    // TC-25: insert binds room type at index 5
    @Test
    public void testInsertReservationRoomType() throws SQLException {
        Reservation res = new Reservation("R-103", "Alice", "Road St",
                "555-9999", "Suite", LocalDate.now(), LocalDate.now().plusDays(1), 300.0);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        reservationDAO.insertReservation(res);
        verify(mockPreparedStatement).setString(5, "Suite");
    }

    // TC-26: insert binds total cost at index 8
    @Test
    public void testInsertReservationTotalCost() throws SQLException {
        Reservation res = new Reservation("R-104", "Charlie", "Lane 5",
                "555-0000", "Standard", LocalDate.now(), LocalDate.now().plusDays(3), 750.0);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        reservationDAO.insertReservation(res);
        verify(mockPreparedStatement).setDouble(8, 750.0);
    }

    // TC-27: get by number maps ResultSet correctly
    @Test
    public void testGetReservationByNumber() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("res_number")).thenReturn("R-101");
        when(mockResultSet.getString("guest_name")).thenReturn("Bob Maker");
        when(mockResultSet.getString("address")).thenReturn("123 Street");
        when(mockResultSet.getString("contact_number")).thenReturn("555-1234");
        when(mockResultSet.getString("room_type")).thenReturn("Suite");
        when(mockResultSet.getDate("check_in")).thenReturn(Date.valueOf(LocalDate.now()));
        when(mockResultSet.getDate("check_out")).thenReturn(Date.valueOf(LocalDate.now().plusDays(1)));
        when(mockResultSet.getDouble("total_cost")).thenReturn(250.0);

        Reservation res = reservationDAO.getReservationByNumber("R-101");
        assertNotNull(res);
        assertEquals("R-101", res.getResNumber());
        assertEquals("Bob Maker", res.getGuestName());
        assertEquals("Suite", res.getRoomType());
        assertEquals(250.0, res.getTotalCost());
    }

    // TC-28: get by number returns null when not found
    @Test
    public void testGetReservationNotFound() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        Reservation res = reservationDAO.getReservationByNumber("INVALID");
        assertNull(res);
    }

    // TC-29: delete binds res_number and calls executeUpdate
    @Test
    public void testDeleteReservation() throws SQLException {
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        reservationDAO.deleteReservation("R-101");
        verify(mockPreparedStatement).setString(1, "R-101");
        verify(mockPreparedStatement).executeUpdate();
    }

    // TC-30: getAllReservations returns list of correct size
    @Test
    public void testGetAllReservations() throws SQLException {
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        // Simulate 2 rows
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("res_number")).thenReturn("R-101");
        when(mockResultSet.getString("guest_name")).thenReturn("Bob Maker");
        when(mockResultSet.getString("address")).thenReturn("123 Street");
        when(mockResultSet.getString("contact_number")).thenReturn("555-1234");
        when(mockResultSet.getString("room_type")).thenReturn("Suite");
        when(mockResultSet.getDate("check_in")).thenReturn(Date.valueOf(LocalDate.now()));
        when(mockResultSet.getDate("check_out")).thenReturn(Date.valueOf(LocalDate.now().plusDays(1)));
        when(mockResultSet.getDouble("total_cost")).thenReturn(250.0);

        List<Reservation> list = reservationDAO.getAllReservations();
        assertEquals(2, list.size());
    }
}
