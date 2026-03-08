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

    // Dependency Injection: DAO Layer එක සම්බන්ධ කිරීම
    private final NotificationDAO notificationDAO = new NotificationDAOImpl();

    @Override
    public Set<NotificationDTO> getUnreadAlertsByRole(String role) throws Exception {
        // Technical Requirement: අනුපිටපත් වැළැක්වීමට Set Interface භාවිතා කර ඇත [cite: 2026-02-14]
        Set<NotificationDTO> unreadSet = new HashSet<>();

        // ඔබ ලබාදුන් DAO method එක භාවිතා කිරීම
        List<Notification> list = notificationDAO.getNotificationsByRole(role);

        for (Notification n : list) {
            // පණිවිඩය කියවා නැතිනම් පමණක් (isRead == false) ලැයිස්තුවට එක් කරයි
            if (!n.isRead()) {
                // Constructor Fix: ඔබේ DTO එකේ ඇති parameters 4ක constructor එක භාවිතා කරන ලදී
                unreadSet.add(new NotificationDTO(
                        n.getNotifId(),
                        n.getMessage(),
                        n.getReceiverRole(),
                        n.getTimestamp().toString() // UI එක සඳහා String එකක් ලෙස ලබා දීම
                ));
            }
        }
        return unreadSet;
    }

    @Override
    public boolean sendAlert(NotificationDTO d) throws Exception {
        // DTO එක Model එකක් බවට පරිවර්තනය කිරීම (Mapping)
        // String timestamp එක java.sql.Timestamp එකක් බවට පත් කිරීම
        Notification model = new Notification(
                d.getNotifId(),
                d.getMessage(),
                d.getReceiverRole(),
                new Timestamp(System.currentTimeMillis()), // වත්මන් වේලාව ලබා ගැනීම
                false // අලුත් alert එකක් නිසා default false වේ
        );
        return notificationDAO.save(model);
    }
}