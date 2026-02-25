package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.UserDAO;
import com.oceanview.ocean_view_resort.model.User;
import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?)");
        pstm.setString(1, user.getUserId());
        pstm.setString(2, user.getUsername());
        pstm.setString(3, user.getPassword());
        pstm.setString(4, user.getRole());
        pstm.setString(5, user.getFullName());
        pstm.setString(6, user.getStatus());
        return pstm.executeUpdate() > 0;
    }

    @Override
    public User findByUsername(String username) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM user WHERE username=?");
        pstm.setString(1, username);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new User(rst.getString(1), rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getString(5), rst.getString(6));
        }
        return null;
    }

    @Override public boolean update(User u) throws SQLException { return false; }
    @Override public boolean delete(String id) throws SQLException { return false; }
    @Override public User findById(String id) throws SQLException { return null; }
    @Override public List<User> findAll() throws SQLException { return new ArrayList<>(); }
}