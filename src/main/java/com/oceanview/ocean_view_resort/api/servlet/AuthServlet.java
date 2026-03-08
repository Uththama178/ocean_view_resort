package com.oceanview.ocean_view_resort.api.servlet;

import com.oceanview.ocean_view_resort.api.dto.UserDTO;
import com.oceanview.ocean_view_resort.api.service.AuthService;
import com.oceanview.ocean_view_resort.api.service.impl.AuthServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/api/auth")
public class AuthServlet extends HttpServlet {
    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if (user == null || user.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
            // empty error .....>index.jsp
            response.sendRedirect(request.getContextPath() + "/index.jsp?error=empty");
            return;
        }

        try {
            UserDTO userDTO = authService.login(user, pass);
            if (userDTO != null) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", userDTO);


                String role = userDTO.getRole(); //

                if ("ADMIN".equals(role)) {
                    response.sendRedirect(request.getContextPath() + "/admin_dashboard.jsp");
                } else if ("RECEPTIONIST".equals(role)) {
                    response.sendRedirect(request.getContextPath() + "/receptionist_dashboard.jsp");
                } else {
                    response.sendRedirect(request.getContextPath() + "/staff_dashboard.jsp");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp?error=invalid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}