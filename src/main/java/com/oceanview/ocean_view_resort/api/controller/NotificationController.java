package com.oceanview.ocean_view_resort.api.controller;

import com.oceanview.ocean_view_resort.api.dto.NotificationDTO;
import com.oceanview.ocean_view_resort.api.service.NotificationService;
import com.oceanview.ocean_view_resort.api.service.impl.NotificationServiceImpl;
import java.util.Set;
import java.util.Collections;

public class NotificationController {
    private final NotificationService notificationService = new NotificationServiceImpl();

    public Set<NotificationDTO> getMyAlerts(String role) {
        try {
            // Unhandled exception
            return notificationService.getUnreadAlertsByRole(role);
        } catch (Exception e) {
            System.err.println("Error loading alerts: " + e.getMessage());
            return Collections.emptySet(); // Error එකකදී හිස් Set එකක් ලබා දීම ආරක්ෂිතයි [cite: 2026-02-14]
        }
    }
}