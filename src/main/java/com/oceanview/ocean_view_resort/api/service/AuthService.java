package com.oceanview.ocean_view_resort.api.service;
import com.oceanview.ocean_view_resort.api.dto.UserDTO;

public interface AuthService {
    UserDTO login(String username, String password) throws Exception;
}