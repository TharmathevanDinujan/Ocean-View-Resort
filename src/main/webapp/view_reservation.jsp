<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.oceanview.model.Reservation" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>View Reservation - Ocean View Resort</title>
            <script src="https://cdn.tailwindcss.com"></script>
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
            <style>
                body {
                    font-family: 'Inter', sans-serif;
                }
            </style>
        </head>

        <body class="bg-slate-50">
            <div class="max-w-2xl mx-auto px-4 py-12">
                <div class="mb-8">
                    <a href="reservation?action=list"
                        class="text-blue-600 hover:text-blue-700 flex items-center font-semibold">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-1" fill="none" viewBox="0 0 24 24"
                            stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M10 19l-7-7m0 0l7-7m-7 7h18" />
                        </svg>
                        Back to Records
                    </a>
                </div>

                <% Reservation res=(Reservation) request.getAttribute("reservation"); if (res !=null) { %>
                    <div class="bg-white rounded-2xl shadow-lg border border-slate-100 overflow-hidden">
                        <div class="bg-slate-800 px-8 py-6 flex justify-between items-center">
                            <div>
                                <h1 class="text-2xl font-bold text-white">Reservation Details</h1>
                                <p class="text-slate-400">ID: <%= res.getResNumber() %>
                                </p>
                            </div>
                            <div class="bg-blue-600 text-white px-4 py-2 rounded-lg font-bold">
                                LKR <%= String.format("%,.2f", res.getTotalCost()) %>
                            </div>
                        </div>

                        <div class="p-8 space-y-8">
                            <div class="grid grid-cols-2 gap-8">
                                <div>
                                    <p class="text-xs font-bold text-slate-400 uppercase tracking-wider mb-1">Guest Name
                                    </p>
                                    <p class="text-lg font-semibold text-slate-800">
                                        <%= res.getGuestName() %>
                                    </p>
                                </div>
                                <div>
                                    <p class="text-xs font-bold text-slate-400 uppercase tracking-wider mb-1">Contact
                                    </p>
                                    <p class="text-lg font-semibold text-slate-800">
                                        <%= res.getContactNumber() %>
                                    </p>
                                </div>
                            </div>

                            <div>
                                <p class="text-xs font-bold text-slate-400 uppercase tracking-wider mb-1">Address</p>
                                <p class="text-slate-700">
                                    <%= res.getAddress() %>
                                </p>
                            </div>

                            <div class="grid grid-cols-3 gap-8 pt-6 border-t border-slate-100">
                                <div>
                                    <p class="text-xs font-bold text-slate-400 uppercase tracking-wider mb-1">Room Type
                                    </p>
                                    <p class="font-semibold text-slate-800">
                                        <%= res.getRoomType() %>
                                    </p>
                                </div>
                                <div>
                                    <p class="text-xs font-bold text-slate-400 uppercase tracking-wider mb-1">Check-in
                                    </p>
                                    <p class="font-semibold text-slate-800">
                                        <%= res.getCheckInDate() %>
                                    </p>
                                </div>
                                <div>
                                    <p class="text-xs font-bold text-slate-400 uppercase tracking-wider mb-1">Check-out
                                    </p>
                                    <p class="font-semibold text-slate-800">
                                        <%= res.getCheckOutDate() %>
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div class="bg-slate-50 px-8 py-6 border-t border-slate-100">
                            <button onclick="window.print()"
                                class="w-full bg-white border border-slate-200 text-slate-700 font-bold py-3 rounded-xl hover:bg-slate-100 transition-colors flex items-center justify-center">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-2" fill="none"
                                    viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                        d="M17 17h2a2 2 0 002-2v-4a2 2 0 00-2-2H5a2 2 0 00-2 2v4a2 2 0 002 2h2m2 4h6a2 2 0 002-2v-4a2 2 0 00-2-2H9a2 2 0 00-2 2v4a2 2 0 002 2zm8-12V5a2 2 0 00-2-2H9a2 2 0 00-2 2v4h10z" />
                                </svg>
                                Print Invoice
                            </button>
                        </div>
                    </div>
                    <% } else { %>
                        <div class="bg-white p-12 rounded-2xl shadow text-center">
                            <p class="text-slate-500">Reservation not found.</p>
                            <a href="reservation?action=list" class="text-blue-600 font-bold mt-4 inline-block">Back to
                                list</a>
                        </div>
                        <% } %>
            </div>
        </body>

        </html>