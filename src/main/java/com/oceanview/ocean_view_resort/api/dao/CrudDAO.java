package com.oceanview.ocean_view_resort.api.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T, ID> {
    boolean save(T entity) throws SQLException, ClassNotFoundException;
    boolean update(T entity) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;
    T findById(ID id) throws SQLException, ClassNotFoundException;
    List<T> findAll() throws SQLException, ClassNotFoundException;
}