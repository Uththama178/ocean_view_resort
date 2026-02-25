package com.oceanview.ocean_view_resort.api.dao;


import com.oceanview.ocean_view_resort.model.Bill;
import java.sql.SQLException;

public interface BillDAO extends CrudDAO<Bill, String> {
    Bill findByReservationId(String resId) throws SQLException, ClassNotFoundException;
}