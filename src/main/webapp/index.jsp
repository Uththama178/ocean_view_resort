<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login | Ocean View Resort</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <style>
        body { font-family: 'Segoe UI', sans-serif; background-color: #e9ecef; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .login-card { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 10px 25px rgba(0,0,0,0.1); width: 350px; }
        h2 { text-align: center; color: #333; margin-bottom: 30px; }
        label { font-weight: bold; color: #555; }
        input { width: 100%; padding: 12px; margin: 8px 0 20px 0; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; }
        button { width: 100%; padding: 12px; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer; font-size: 16px; transition: 0.3s; }
        button:hover { background-color: #218838; }
        .error-msg { color: #dc3545; text-align: center; font-size: 14px; margin-bottom: 10px; }
    </style>
</head>
<body>
<div class="login-card">
    <h2>Ocean View Login</h2>


    <%
        String error = request.getParameter("error");
        if(error != null) {
            if(error.equals("empty")) { %>
    <div class="error-msg">All Fields are required!</div>
    <% } else if(error.equals("invalid")) { %>
    <div class="error-msg">Invalid Username or Password!</div>
    <% }
    }
    %>

    <form action="api/auth" method="POST">
        <label>Username</label>
        <input type="text" name="username" placeholder="Enter your username" required>

        <label>Password</label>
        <input type="password" name="password" placeholder="Enter your password" required>

        <button type="submit">Login Now</button>
    </form>
    <p style="text-align: center; font-size: 14px;">New Staff? <a href="signup.jsp">Create Account</a></p>
</div>

<script>

    document.addEventListener('DOMContentLoaded', function() {
        const urlParams = new URLSearchParams(window.location.search);

        if (urlParams.has('message') && urlParams.get('message') === 'logout_success') {
            Swal.fire({
                icon: 'success',
                title: 'Logged Out!',
                text: 'You have been successfully logged out of the system.',
                timer: 3000,
                showConfirmButton: false
            });


            window.history.replaceState({}, document.title, window.location.pathname);
        }
    });
</script>
</body>
</html>