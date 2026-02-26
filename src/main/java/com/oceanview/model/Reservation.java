package com.oceanview.model;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private String resNumber;
    private String guestName;
    private String address;
    private String contactNumber;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalCost;

    // Constructors
    public Reservation() {}

    public Reservation(String resNumber, String guestName, String address, String contactNumber, 
                       String roomType, LocalDate checkInDate, LocalDate checkOutDate, double totalCost) {
        this.resNumber = resNumber;
        this.guestName = guestName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalCost = totalCost;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getResNumber() { return resNumber; }
    public void setResNumber(String resNumber) { this.resNumber = resNumber; }

    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }

    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
}
