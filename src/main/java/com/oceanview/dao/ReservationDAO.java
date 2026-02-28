package com.oceanview.dao;

import com.oceanview.model.Reservation;
import com.oceanview.util.DBConnection;

import java.sql.*;

public class ReservationDAO {
    private static final String INSERT_RESERVATION_SQL = "INSERT INTO reservations (res_number, guest_name, address, contact_number, room_type, check_in, check_out, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public void insertReservation(Reservation reservation) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_SQL)) {
            preparedStatement.setString(1, reservation.getResNumber());
            preparedStatement.setString(2, reservation.getGuestName());
            preparedStatement.setString(3, reservation.getAddress());
            preparedStatement.setString(4, reservation.getContactNumber());
            preparedStatement.setString(5, reservation.getRoomType());
            preparedStatement.setDate(6, Date.valueOf(reservation.getCheckInDate()));
            preparedStatement.setDate(7, Date.valueOf(reservation.getCheckOutDate()));
            preparedStatement.setDouble(8, reservation.getTotalCost());
            preparedStatement.executeUpdate();
        }
    }
}
