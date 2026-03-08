package com.oceanview.ocean_view_resort.api.dao;

import com.oceanview.ocean_view_resort.model.Room;
import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room, String> {
    List<Room> findAvailableRooms() throws SQLException, ClassNotFoundException;
}