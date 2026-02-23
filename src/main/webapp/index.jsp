<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Ocean View Resort</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <style>
        body { font-family: 'Inter', sans-serif; }
    </style>
</head>
<body class="bg-slate-50 flex items-center justify-center min-h-screen">
    <div class="bg-white p-8 rounded-2xl shadow-xl w-full max-w-md border border-slate-100">
        <div class="text-center mb-8">
            <h1 class="text-3xl font-bold text-slate-800">Ocean View Resort</h1>
            <p class="text-slate-500 mt-2">Management System Portal</p>
        </div>

        <% String error = request.getParameter("error"); %>
        <% if (error != null) { %>
            <div class="bg-red-50 border-l-4 border-red-500 p-4 mb-6">
                <p class="text-red-700 text-sm"><%= error %></p>
            </div>
        <% } %>

        <form action="login" method="POST" class="space-y-6">
            <div>
                <label class="block text-sm font-semibold text-slate-700 mb-2">Username</label>
                <input type="text" name="username" required 
                    class="w-full px-4 py-3 rounded-lg border border-slate-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all outline-none"
                    placeholder="Enter your username">
            </div>
            <div>
                <label class="block text-sm font-semibold text-slate-700 mb-2">Password</label>
                <input type="password" name="password" required 
                    class="w-full px-4 py-3 rounded-lg border border-slate-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-all outline-none"
                    placeholder="••••••••">
            </div>
            <button type="submit" 
                class="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 rounded-lg shadow-lg hover:shadow-xl transition-all transform hover:-translate-y-0.5 active:translate-y-0">
                Sign In
            </button>
        </form>
        
        <div class="mt-8 pt-6 border-t border-slate-100 text-center">
            <p class="text-slate-400 text-xs">Developed for Galle's Premier Beachside Hotel</p>
        </div>
    </div>
</body>
</html>
