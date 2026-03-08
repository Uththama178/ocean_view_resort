package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.ReservationDAO;
import com.oceanview.ocean_view_resort.model.Reservation;
import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public boolean save(Reservation entity) throws SQLException {
        //  resId, guestId, roomId, checkIn, checkOut, status, total_amount
        String sql = "INSERT INTO reservation VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, entity.getResId());
            pstm.setString(2, entity.getGuestId());
            pstm.setString(3, entity.getRoomId());
            pstm.setDate(4, Date.valueOf(entity.getCheckIn()));
            pstm.setDate(5, Date.valueOf(entity.getCheckOut()));
            pstm.setString(6, entity.getStatus());
            pstm.setDouble(7, entity.getTotalAmount());

            return pstm.executeUpdate() > 0;
        }
    }


    @Override public boolean update(Reservation entity) throws SQLException { return false; }
    @Override public boolean delete(String s) throws SQLException { return false; }
    @Override public Reservation findById(String s) throws SQLException { return null; }
    // ReservationDAOImpl.java
    @Override
    public List<Reservation> findAll() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservation";

        try (Connection connection = DBConnection.getConnection();
             Statement stm = connection.createStatement();
             ResultSet rst = stm.executeQuery(sql)) {

            while (rst.next()) {
                reservations.add(new Reservation(
                        rst.getString(1), rst.getString(2), rst.getString(3),
                        rst.getDate(4).toLocalDate(), rst.getDate(5).toLocalDate(),
                        rst.getString(6), rst.getDouble(7)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Console  Error
            throw new SQLException(e.getMessage()); // Servlet
        }
        return reservations;
    }
}
