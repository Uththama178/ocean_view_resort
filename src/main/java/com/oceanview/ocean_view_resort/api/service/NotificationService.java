package com.oceanview.ocean_view_resort.api.service;
import com.oceanview.ocean_view_resort.api.dto.NotificationDTO;
import java.util.Set;

public interface NotificationService {
    boolean sendAlert(NotificationDTO dto) throws Exception;
    Set<NotificationDTO> getUnreadAlertsByRole(String role) throws Exception;
}
