<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.oceanview.model.Reservation" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Reservations List - Ocean View Resort</title>
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
                <div class="max-w-7xl mx-auto px-4 py-12">
                    <div class="flex justify-between items-center mb-8">
                        <a href="dashboard.jsp"
                            class="text-blue-600 hover:text-blue-700 flex items-center font-semibold">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-1" fill="none" viewBox="0 0 24 24"
                                stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M10 19l-7-7m0 0l7-7m-7 7h18" />
                            </svg>
                            Back to Dashboard
                        </a>
                        <h1 class="text-3xl font-bold text-slate-800">Reservation Records</h1>
                    </div>

                    <div class="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
                        <table class="w-full text-left">
                            <thead class="bg-slate-50 border-b border-slate-100">
                                <tr>
                                    <th class="px-6 py-4 text-sm font-semibold text-slate-700">Res #</th>
                                    <th class="px-6 py-4 text-sm font-semibold text-slate-700">Guest Name</th>
                                    <th class="px-6 py-4 text-sm font-semibold text-slate-700">Room</th>
                                    <th class="px-6 py-4 text-sm font-semibold text-slate-700">Check-in</th>
                                    <th class="px-6 py-4 text-sm font-semibold text-slate-700">Check-out</th>
                                    <th class="px-6 py-4 text-sm font-semibold text-slate-700">Total Bill</th>
                                    <th class="px-6 py-4 text-sm font-semibold text-slate-700 text-right">Actions</th>
                                </tr>
                            </thead>
                            <tbody class="divide-y divide-slate-100">
                                <% List<Reservation> reservations = (List<Reservation>)
                                        request.getAttribute("reservations");
                                        if (reservations != null && !reservations.isEmpty()) {
                                        for (Reservation res : reservations) {
                                        %>
                                        <tr class="hover:bg-slate-50 transition-colors">
                                            <td class="px-6 py-4 text-sm font-medium text-blue-600">
                                                <%= res.getResNumber() %>
                                            </td>
                                            <td class="px-6 py-4 text-sm text-slate-700">
                                                <%= res.getGuestName() %>
                                            </td>
                                            <td class="px-6 py-4 text-sm text-slate-600">
                                                <%= res.getRoomType() %>
                                            </td>
                                            <td class="px-6 py-4 text-sm text-slate-600">
                                                <%= res.getCheckInDate() %>
                                            </td>
                                            <td class="px-6 py-4 text-sm text-slate-600">
                                                <%= res.getCheckOutDate() %>
                                            </td>
                                            <td class="px-6 py-4 text-sm font-bold text-slate-800">LKR <%= String.format("%,.2f", res.getTotalCost()) %>
                                            </td>
                                            <td class="px-6 py-4 text-sm text-right">
                                                <a href="reservation?action=view&resNumber=<%= res.getResNumber() %>"
                                                   class="text-blue-600 hover:text-blue-800 font-semibold mr-3">View</a>
                                                <a href="reservation?action=delete&resNumber=<%= res.getResNumber() %>"
                                                   onclick="return confirm('Are you sure you want to delete reservation <%= res.getResNumber() %>?');"
                                                   class="text-red-500 hover:text-red-700 font-semibold">Delete</a>
                                            </td>
                                        </tr>
                                        <% } } else { %>
                                            <tr>
                                                <td colspan="6" class="px-6 py-12 text-center text-slate-500">No
                                                    reservations found.</td>
                                            </tr>
                                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </body>

            </html>