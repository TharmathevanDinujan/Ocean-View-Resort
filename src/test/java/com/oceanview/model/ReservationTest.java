package com.oceanview.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {

    // TC-07
    @Test
    public void testReservationDefaultConstructor() {
        Reservation res = new Reservation();
        assertNotNull(res);
    }

    // TC-08
    @Test
    public void testReservationGettersAndSetters() {
        Reservation res = new Reservation();
        res.setId(10);
        res.setResNumber("RES-1001");
        res.setGuestName("John Doe");
        res.setAddress("123 Ocean Drive");
        res.setContactNumber("1234567890");
        res.setRoomType("Deluxe");
        LocalDate checkIn = LocalDate.of(2023, 10, 1);
        LocalDate checkOut = LocalDate.of(2023, 10, 5);
        res.setCheckInDate(checkIn);
        res.setCheckOutDate(checkOut);
        res.setTotalCost(400.0);

        assertEquals(10, res.getId());
        assertEquals("RES-1001", res.getResNumber());
        assertEquals("John Doe", res.getGuestName());
        assertEquals("123 Ocean Drive", res.getAddress());
        assertEquals("1234567890", res.getContactNumber());
        assertEquals("Deluxe", res.getRoomType());
        assertEquals(checkIn, res.getCheckInDate());
        assertEquals(checkOut, res.getCheckOutDate());
        assertEquals(400.0, res.getTotalCost());
    }

    // TC-09
    @Test
    public void testReservationParameterisedConstructor() {
        LocalDate in = LocalDate.of(2023, 11, 1);
        LocalDate out = LocalDate.of(2023, 11, 3);
        Reservation res = new Reservation("RES-1002", "Jane Smith",
                "456 Beach Blvd", "0987654321", "Standard", in, out, 200.0);
        assertEquals("RES-1002", res.getResNumber());
        assertEquals("Jane Smith", res.getGuestName());
        assertEquals(200.0, res.getTotalCost());
    }

    // TC-10
    @Test
    public void testReservationSetResNumber() {
        Reservation res = new Reservation();
        res.setResNumber("R-999");
        assertEquals("R-999", res.getResNumber());
    }

    // TC-11
    @Test
    public void testReservationSetGuestName() {
        Reservation res = new Reservation();
        res.setGuestName("Alexander James William Thornton");
        assertEquals("Alexander James William Thornton", res.getGuestName());
    }

    // TC-12
    @Test
    public void testReservationCheckInDate() {
        Reservation res = new Reservation();
        LocalDate date = LocalDate.of(2024, 1, 15);
        res.setCheckInDate(date);
        assertEquals(date, res.getCheckInDate());
    }

    // TC-13
    @Test
    public void testReservationCheckOutDate() {
        Reservation res = new Reservation();
        LocalDate date = LocalDate.of(2024, 1, 20);
        res.setCheckOutDate(date);
        assertEquals(date, res.getCheckOutDate());
    }

    // TC-14
    @Test
    public void testReservationTotalCostZero() {
        Reservation res = new Reservation();
        res.setTotalCost(0.0);
        assertEquals(0.0, res.getTotalCost());
    }

    // TC-15
    @Test
    public void testReservationTotalCostNegative() {
        Reservation res = new Reservation();
        res.setTotalCost(-1.0);
        assertEquals(-1.0, res.getTotalCost());
    }

    // TC-16
    @Test
    public void testReservationSetRoomType() {
        Reservation res = new Reservation();
        res.setRoomType("Suite");
        assertEquals("Suite", res.getRoomType());
    }

    // TC-17
    @Test
    public void testReservationContactNumber() {
        Reservation res = new Reservation();
        res.setContactNumber("0771234567");
        assertEquals("0771234567", res.getContactNumber());
    }
}
