<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.oceanview.model.User" %>
        <% User user=(User) session.getAttribute("user"); if (user==null) {
            response.sendRedirect("index.jsp?error=Please login first"); return; } %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Dashboard - Ocean View Resort</title>
                <script src="https://cdn.tailwindcss.com"></script>
                <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap"
                    rel="stylesheet">
                <style>
                    body {
                        font-family: 'Inter', sans-serif;
                    }
                </style>
            </head>

            <body class="bg-slate-50">
                <nav class="bg-white shadow-sm border-b border-slate-200">
                    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                        <div class="flex justify-between h-16 items-center">
                            <div class="flex items-center">
                                <span class="text-2xl font-bold text-blue-600">Ocean View Resort</span>
                            </div>
                            <div class="flex items-center space-x-4">
                                <span class="text-slate-600 font-medium">Welcome, <%= user.getUsername() %></span>
                                <a href="logout.jsp"
                                    class="text-red-600 hover:text-red-700 font-semibold px-3 py-2 rounded-md transition-colors">Logout</a>
                            </div>
                        </div>
                    </div>
                </nav>

                <main class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
                    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                        <!-- Add Reservation Card -->
                        <a href="add_reservation.jsp"
                            class="group bg-white p-8 rounded-2xl shadow-sm border border-slate-100 hover:shadow-md transition-all transform hover:-translate-y-1">
                            <div
                                class="w-12 h-12 bg-blue-100 rounded-lg flex items-center justify-center mb-6 text-blue-600 group-hover:bg-blue-600 group-hover:text-white transition-colors">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                                    stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                        d="M12 4v16m8-8H4" />
                                </svg>
                            </div>
                            <h3 class="text-xl font-bold text-slate-800 mb-2">New Reservation</h3>
                            <p class="text-slate-500">Register a new guest and create a room booking.</p>
                        </a>

                        <!-- View Reservations Card -->
                        <a href="reservation?action=list"
                            class="group bg-white p-8 rounded-2xl shadow-sm border border-slate-100 hover:shadow-md transition-all transform hover:-translate-y-1">
                            <div
                                class="w-12 h-12 bg-green-100 rounded-lg flex items-center justify-center mb-6 text-green-600 group-hover:bg-green-600 group-hover:text-white transition-colors">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                                    stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                        d="M4 6h16M4 10h16M4 14h16M4 18h16" />
                                </svg>
                            </div>
                            <h3 class="text-xl font-bold text-slate-800 mb-2">Manage Bookings</h3>
                            <p class="text-slate-500">View and manage all existing guest reservations.</p>
                        </a>

                        <!-- Help & Guidelines Card -->
                        <a href="help.jsp"
                            class="group bg-white p-8 rounded-2xl shadow-sm border border-slate-100 hover:shadow-md transition-all transform hover:-translate-y-1">
                            <div
                                class="w-12 h-12 bg-amber-100 rounded-lg flex items-center justify-center mb-6 text-amber-600 group-hover:bg-amber-600 group-hover:text-white transition-colors">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                                    stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                        d="M8.228 9c.549-1.165 2.03-2 3.772-2 2.21 0 4 1.343 4 3 0 1.4-1.278 2.575-3.006 2.907-.542.104-.994.54-.994 1.093m0 3h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                            </div>
                            <h3 class="text-xl font-bold text-slate-800 mb-2">Help Center</h3>
                            <p class="text-slate-500">Guidelines for staff members on using the system.</p>
                        </a>
                    </div>

                    <% String success=request.getParameter("success"); %>
                        <% if (success !=null) { %>
                            <div class="mt-8 bg-green-50 border-l-4 border-green-500 p-4 rounded-r-lg">
                                <p class="text-green-700 font-medium">
                                    <%= success %>
                                </p>
                            </div>
                            <% } %>
                </main>
            </body>

            </html>