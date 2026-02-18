-- Database setup script for Ocean View Resort
CREATE DATABASE IF NOT EXISTS ocean_view_resort;
USE ocean_view_resort;

-- Drop tables if they exist to start fresh
DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS users;

-- Create users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create reservations table
CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    res_number VARCHAR(20) UNIQUE NOT NULL,
    guest_name VARCHAR(100) NOT NULL,
    address TEXT,
    contact_number VARCHAR(20),
    room_type VARCHAR(50),
    check_in DATE,
    check_out DATE,
    total_cost DECIMAL(10, 2)
);

-- Insert default admin user
INSERT INTO users (username, password) VALUES ('admin', 'admin123');

-- Insert sample reservation data (Optional)
INSERT INTO reservations (res_number, guest_name, address, contact_number, room_type, check_in, check_out, total_cost) 
VALUES ('RES_SAMPLE_01', 'John Doe', '123 Beach Road, Galle', '0771234567', 'Deluxe', '2026-03-01', '2026-03-05', 600.00);
