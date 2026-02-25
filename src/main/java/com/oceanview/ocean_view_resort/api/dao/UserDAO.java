package com.oceanview.ocean_view_resort.api.dao;

import com.oceanview.ocean_view_resort.model.User;
import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User, String> {
    User findByUsername(String username) throws SQLException, ClassNotFoundException;
}