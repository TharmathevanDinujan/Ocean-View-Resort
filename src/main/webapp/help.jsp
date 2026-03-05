<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Help & Guidelines - Ocean View Resort</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
        <style>
            body {
                font-family: 'Inter', sans-serif;
            }
        </style>
    </head>

    <body class="bg-slate-50">
        <div class="max-w-4xl mx-auto px-4 py-12">
            <div class="mb-8">
                <a href="dashboard.jsp" class="text-blue-600 hover:text-blue-700 flex items-center font-semibold">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 mr-1" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M10 19l-7-7m0 0l7-7m-7 7h18" />
                    </svg>
                    Back to Dashboard
                </a>
            </div>

            <div class="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
                <div class="bg-amber-500 px-8 py-6">
                    <h1 class="text-2xl font-bold text-white">System Guidelines</h1>
                    <p class="text-amber-100 mt-1">Information for new staff members</p>
                </div>

                <div class="p-8 space-y-12">
                    <section>
                        <h2 class="text-xl font-bold text-slate-800 mb-4 flex items-center">
                            <span
                                class="w-8 h-8 rounded-full bg-slate-100 flex items-center justify-center mr-3 text-sm">01</span>
                            User Authentication
                        </h2>
                        <p class="text-slate-600 leading-relaxed">
                            To access the system, you must use your assigned username and password. Logging out after
                            each shift is mandatory for security. Do not share your credentials with anyone.
                        </p>
                    </section>

                    <section>
                        <h2 class="text-xl font-bold text-slate-800 mb-4 flex items-center">
                            <span
                                class="w-8 h-8 rounded-full bg-slate-100 flex items-center justify-center mr-3 text-sm">02</span>
                            Creating Reservations
                        </h2>
                        <p class="text-slate-600 leading-relaxed">
                            When a new guest arrives, navigate to 'New Reservation'. Enter their full name, contact
                            number, and correct address. Ensure the check-in and check-out dates are accurate, as these
                            are used for billing calculations.
                        </p>
                        <div class="mt-4 p-4 bg-blue-50 border-l-4 border-blue-400 text-blue-800 text-sm">
                            <strong>Pro Tip:</strong> Suite rooms have a premium rate but offer the best guest
                            experience.
                        </div>
                    </section>

                    <section>
                        <h2 class="text-xl font-bold text-slate-800 mb-4 flex items-center">
                            <span
                                class="w-8 h-8 rounded-full bg-slate-100 flex items-center justify-center mr-3 text-sm">03</span>
                            Billing & Invoicing
                        </h2>
                        <p class="text-slate-600 leading-relaxed">
                            The system automatically calculates the total bill based on the room rate and the number of
                            nights. You can view and print the invoice directly from the 'Manage Bookings' section by
                            clicking on a specific reservation.
                        </p>
                    </section>

                    <section>
                        <h2 class="text-xl font-bold text-slate-800 mb-4 flex items-center">
                            <span
                                class="w-8 h-8 rounded-full bg-slate-100 flex items-center justify-center mr-3 text-sm">04</span>
                            Data Privacy
                        </h2>
                        <p class="text-slate-600 leading-relaxed">
                            Always verify guest identity before displaying reservation details. Protect guest contact
                            information at all times.
                        </p>
                    </section>
                </div>
            </div>
        </div>
    </body>

    </html>