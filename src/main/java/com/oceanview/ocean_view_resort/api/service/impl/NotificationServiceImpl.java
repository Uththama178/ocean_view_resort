package com.oceanview.ocean_view_resort.api.service.impl;

import com.oceanview.ocean_view_resort.api.dao.NotificationDAO;
import com.oceanview.ocean_view_resort.api.dao.impl.NotificationDAOImpl;
import com.oceanview.ocean_view_resort.api.dto.NotificationDTO;
import com.oceanview.ocean_view_resort.api.service.NotificationService;
import com.oceanview.ocean_view_resort.model.Notification;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotificationServiceImpl implements NotificationService {

    // Dependency Injection: DAO Layer
    private final NotificationDAO notificationDAO = new NotificationDAOImpl();

    @Override
    public Set<NotificationDTO> getUnreadAlertsByRole(String role) throws Exception {
        // Technical Requirement: Use det Interface
        Set<NotificationDTO> unreadSet = new HashSet<>();


        List<Notification> list = notificationDAO.getNotificationsByRole(role);

        for (Notification n : list) {
            // Adds the message to the list only if it is unread (isRead == false).
            if (!n.isRead()) {
                // Constructor Fix: The 4-parameter constructor in your DTO was used.
                unreadSet.add(new NotificationDTO(
                        n.getNotifId(),
                        n.getMessage(),
                        n.getReceiverRole(),
                        n.getTimestamp().toString() // Provide as a String for the UI
                ));
            }
        }
        return unreadSet;
    }

    @Override
    public boolean sendAlert(NotificationDTO d) throws Exception {
        // Converting a DTO to a Model (Mapping)
        // Converting a String timestamp to a java.sql.Timestamp
        Notification model = new Notification(
                d.getNotifId(),
                d.getMessage(),
                d.getReceiverRole(),
                new Timestamp(System.currentTimeMillis()), // Get the current time
                false // අලුත් alert එකක් නිසා default false වේ
        );
        return notificationDAO.save(model);
    }
}