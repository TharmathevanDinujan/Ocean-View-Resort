# Ocean View Resort Management System

A comprehensive web-based management system for Ocean View Resort, a premier beachside hotel in Galle. This system automates room reservations, guest recording, and billing to replace manual processes and eliminate booking conflicts.

## 🚀 Features

- **Staff Authentication**: Secure login for authorized personnel.
- **Guest Registration**: Efficiently collect and store guest details.
- **Reservation Management**: Create, view, and track room bookings.
- **Automated Billing**: Instant cost calculation based on room types and stay duration.
- **Help Center**: Onboarding guidelines for new staff members.
- **Printable Invoices**: Professional billing summaries ready for printing.

## 🛠️ Technology Stack

- **Backend**: Java EE (Servlets, DAO Pattern)
- **Database**: MySQL
- **Frontend**: JSP, Tailwind CSS (via CDN)
- **Build Tool**: Maven

## 📋 Prerequisites

- **Java JDK 11+**
- **Apache Tomcat 9.0+**
- **MySQL Server 8.0+**
- **Maven**

## 🔧 Database Setup

1. Open MySQL Workbench.
2. Run the `db_setup.sql` script located in the root directory.
3. This will create the `ocean_view_resort` database and a default admin user.

**Default Credentials:**
- **Username**: `admin`
- **Password**: `admin123`

## 💻 Installation & Running

1. Clone the repository:
   ```bash
   git clone https://github.com/TharmathevanDinujan/Ocean-View-Resort.git
   ```
2. Open the project in **IntelliJ IDEA**.
3. Configure a **Tomcat (Local)** server.
4. Deploy the `ResortManagement:war exploded` artifact.
5. Run the server and navigate to `http://localhost:8080/ResortManagement/`.

## 📸 Screenshots

*(Add your screenshots here after deployment)*

## 📄 License

This project is developed for educational purposes as part of a resort management system assignment.
