package com.oceanview.ocean_view_resort.api.service;

import com.oceanview.ocean_view_resort.api.dto.RoomDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import java.util.List;

public interface RoomService {
    ResponseDTO<Boolean> addNewRoom(RoomDTO roomDTO);
    ResponseDTO<List<RoomDTO>> getAvailableRooms();
    ResponseDTO<Boolean> updateRoomStatus(String roomId, String status);
    ResponseDTO<RoomDTO> getRoomDetails(String roomId);
}
