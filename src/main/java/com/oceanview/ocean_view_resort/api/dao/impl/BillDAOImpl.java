package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.BillDAO;
import com.oceanview.ocean_view_resort.model.Bill;
import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO {
    @Override
    public boolean save(Bill bill) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO bill (billId, resId, totalAmount) VALUES(?,?,?)");
        pstm.setString(1, bill.getBillId());
        pstm.setString(2, bill.getResId());
        pstm.setDouble(3, bill.getTotalAmount());
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Bill findByReservationId(String resId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM bill WHERE resId=?");
        pstm.setString(1, resId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Bill(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getTimestamp(4));
        }
        return null;
    }

    @Override public boolean update(Bill b) throws SQLException { return false; }
    @Override public boolean delete(String id) throws SQLException { return false; }
    @Override public Bill findById(String id) throws SQLException { return null; }
    @Override public List<Bill> findAll() throws SQLException { return new ArrayList<>(); }
}