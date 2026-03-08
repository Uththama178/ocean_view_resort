package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.ReservationDAO;
import com.oceanview.ocean_view_resort.model.Reservation;
import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation res) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO reservation VALUES(?,?,?,?,?,?)");
        pstm.setString(1, res.getResId());
        pstm.setString(2, res.getGuestId());
        pstm.setString(3, res.getRoomId());
        pstm.setDate(4, res.getCheckIn());
        pstm.setDate(5, res.getCheckOut());
        pstm.setString(6, res.getStatus());
        return pstm.executeUpdate() > 0;
    }

    @Override public boolean update(Reservation r) throws SQLException { return false; }
    @Override public boolean delete(String id) throws SQLException { return false; }
    @Override public Reservation findById(String id) throws SQLException { return null; }
    @Override public List<Reservation> findAll() throws SQLException { return new ArrayList<>(); }
}