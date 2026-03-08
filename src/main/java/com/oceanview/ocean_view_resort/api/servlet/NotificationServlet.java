package com.oceanview.ocean_view_resort.api.servlet;
import com.oceanview.ocean_view_resort.api.dto.NotificationDTO;
import com.oceanview.ocean_view_resort.api.service.NotificationService;
import com.oceanview.ocean_view_resort.api.service.impl.NotificationServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "NotificationServlet", value = "/api/alerts")
public class NotificationServlet extends HttpServlet {
    private final NotificationService notificationService = new NotificationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = request.getParameter("role");
        try {
            Set<NotificationDTO> alerts = notificationService.getUnreadAlertsByRole(role);
            // Simply show the number of alerts
            response.getWriter().write("You have " + alerts.size() + " unread alerts.");
        } catch (Exception e) {
            response.sendError(500, e.getMessage());
        }
    }
}
