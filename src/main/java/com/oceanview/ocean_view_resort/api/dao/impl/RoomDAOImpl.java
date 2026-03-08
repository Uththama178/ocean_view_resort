package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.RoomDAO;
import com.oceanview.ocean_view_resort.model.Room;
import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room room) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO room VALUES(?,?,?,?)");
        pstm.setString(1, room.getRoomId());
        pstm.setString(2, room.getType());
        pstm.setDouble(3, room.getPrice());
        pstm.setString(4, room.getStatus());
        return pstm.executeUpdate() > 0;
    }

    @Override
    public List<Room> findAvailableRooms() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM room WHERE status='AVAILABLE'");
        ResultSet rst = pstm.executeQuery();
        List<Room> rooms = new ArrayList<>();
        while (rst.next()) {
            rooms.add(new Room(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getString(4)));
        }
        return rooms;
    }

    @Override public boolean update(Room r) throws SQLException { return false; }
    @Override public boolean delete(String id) throws SQLException { return false; }
    @Override public Room findById(String id) throws SQLException { return null; }
    @Override public List<Room> findAll() throws SQLException { return new ArrayList<>(); }
}