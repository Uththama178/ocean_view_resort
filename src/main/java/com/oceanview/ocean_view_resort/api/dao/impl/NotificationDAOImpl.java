package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.NotificationDAO;
import com.oceanview.ocean_view_resort.model.Notification;
import com.oceanview.ocean_view_resort.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAOImpl implements NotificationDAO {

    @Override
    public boolean save(Notification n) throws Exception {
        // Corrected: Using the direct static method from your DBConnection class
        Connection connection = DBConnection.getConnection();

        String sql = "INSERT INTO notification (notifId, message, receiverRole, timestamp, isRead) VALUES(?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, n.getNotifId());
        pstm.setObject(2, n.getMessage());
        pstm.setObject(3, n.getReceiverRole());
        pstm.setObject(4, n.getTimestamp());
        pstm.setObject(5, n.isRead());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public List<Notification> getNotificationsByRole(String role) throws Exception {
        Connection connection = DBConnection.getConnection();

        String sql = "SELECT * FROM notification WHERE receiverRole=? ORDER BY timestamp DESC";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, role);

        ResultSet rst = pstm.executeQuery();
        List<Notification> notifications = new ArrayList<>();

        while (rst.next()) {
            notifications.add(new Notification(
                    rst.getString("notifId"),
                    rst.getString("message"),
                    rst.getString("receiverRole"),
                    rst.getTimestamp("timestamp"),
                    rst.getBoolean("isRead")
            ));
        }
        return notifications;
    }

    @Override
    public boolean markAsRead(String notifId) throws Exception {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE notification SET isRead=true WHERE notifId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, notifId);
        return pstm.executeUpdate() > 0;
    }
}