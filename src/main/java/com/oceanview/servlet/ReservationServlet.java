package com.oceanview.servlet;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    private ReservationDAO reservationDAO;

    @Override
    public void init() {
        reservationDAO = new ReservationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addReservation(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("view".equals(action)) {
            viewReservation(request, response);
        } else if ("list".equals(action)) {
            listReservations(request, response);
        } else if ("delete".equals(action)) {
            deleteReservation(request, response);
        }
    }

    private void addReservation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String resNumber = "RES" + System.currentTimeMillis(); // Simple unique number
        String guestName = request.getParameter("guestName");
        String address = request.getParameter("address");
        String contactNumber = request.getParameter("contactNumber");
        String roomType = request.getParameter("roomType");
        LocalDate checkIn = LocalDate.parse(request.getParameter("checkIn"));
        LocalDate checkOut = LocalDate.parse(request.getParameter("checkOut"));

        // Billing Logic
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        double rate = getRoomRate(roomType);
        double totalCost = nights * rate;

        Reservation reservation = new Reservation(resNumber, guestName, address, contactNumber, roomType, checkIn,
                checkOut, totalCost);

        try {
            reservationDAO.insertReservation(reservation);
            response.sendRedirect("dashboard.jsp?success=Reservation added! Bill: LKR " + totalCost);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("add_reservation.jsp?error=Failed to add reservation");
        }
    }

    private void viewReservation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resNumber = request.getParameter("resNumber");
        try {
            Reservation reservation = reservationDAO.getReservationByNumber(resNumber);
            request.setAttribute("reservation", reservation);
            request.getRequestDispatcher("view_reservation.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp?error=Error retrieving reservation");
        }
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Reservation> list = reservationDAO.getAllReservations();
            request.setAttribute("reservations", list);
            request.getRequestDispatcher("list_reservations.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.jsp?error=Error listing reservations");
        }
    }

    private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String resNumber = request.getParameter("resNumber");
        try {
            reservationDAO.deleteReservation(resNumber);
            response.sendRedirect("reservation?action=list&success=Reservation deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("reservation?action=list&error=Failed to delete reservation");
        }
    }

    private double getRoomRate(String roomType) {
        switch (roomType) {
            case "Deluxe":
                return 45000.0;
            case "Standard":
                return 25000.0;
            case "Suite":
                return 75000.0;
            default:
                return 20000.0;
        }
    }
}
