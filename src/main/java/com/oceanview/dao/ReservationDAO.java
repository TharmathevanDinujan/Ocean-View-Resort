package com.oceanview.dao;

import com.oceanview.model.Reservation;
import com.oceanview.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private static final String INSERT_RESERVATION_SQL = "INSERT INTO reservations (res_number, guest_name, address, contact_number, room_type, check_in, check_out, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_RESERVATION_BY_NUMBER = "SELECT * FROM reservations WHERE res_number = ?";
    private static final String SELECT_ALL_RESERVATIONS = "SELECT * FROM reservations";

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

    public Reservation getReservationByNumber(String resNumber) throws SQLException {
        Reservation reservation = null;
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVATION_BY_NUMBER)) {
            preparedStatement.setString(1, resNumber);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                reservation = new Reservation();
                reservation.setId(rs.getInt("id"));
                reservation.setResNumber(rs.getString("res_number"));
                reservation.setGuestName(rs.getString("guest_name"));
                reservation.setAddress(rs.getString("address"));
                reservation.setContactNumber(rs.getString("contact_number"));
                reservation.setRoomType(rs.getString("room_type"));
                reservation.setCheckInDate(rs.getDate("check_in").toLocalDate());
                reservation.setCheckOutDate(rs.getDate("check_out").toLocalDate());
                reservation.setTotalCost(rs.getDouble("total_cost"));
            }
        }
        return reservation;
    }

    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATIONS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt("id"));
                reservation.setResNumber(rs.getString("res_number"));
                reservation.setGuestName(rs.getString("guest_name"));
                reservation.setAddress(rs.getString("address"));
                reservation.setContactNumber(rs.getString("contact_number"));
                reservation.setRoomType(rs.getString("room_type"));
                reservation.setCheckInDate(rs.getDate("check_in").toLocalDate());
                reservation.setCheckOutDate(rs.getDate("check_out").toLocalDate());
                reservation.setTotalCost(rs.getDouble("total_cost"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }
}
