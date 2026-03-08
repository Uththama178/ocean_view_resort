package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.GuestDAO;
import com.oceanview.ocean_view_resort.model.Guest;
import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAOImpl implements GuestDAO {
    @Override
    public boolean save(Guest guest) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO guest VALUES(?,?,?,?,?)");
        pstm.setString(1, guest.getGuestId());
        pstm.setString(2, guest.getName());
        pstm.setString(3, guest.getContact());
        pstm.setString(4, guest.getEmail());
        pstm.setString(5, guest.getNic());
        return pstm.executeUpdate() > 0;
    }

    @Override public boolean update(Guest g) throws SQLException { return false; }
    @Override public boolean delete(String id) throws SQLException { return false; }
    @Override public Guest findById(String id) throws SQLException { return null; }
    @Override public List<Guest> findAll() throws SQLException { return new ArrayList<>(); }
}