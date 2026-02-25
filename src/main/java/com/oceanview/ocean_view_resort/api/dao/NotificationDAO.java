package com.oceanview.ocean_view_resort.api.dao;

import com.oceanview.ocean_view_resort.model.Notification;
import java.util.List;

public interface NotificationDAO {
    boolean save(Notification notification) throws Exception;
    List<Notification> getNotificationsByRole(String role) throws Exception;
    boolean markAsRead(String notifId) throws Exception;
}
