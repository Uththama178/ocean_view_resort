package com.oceanview.ocean_view_resort.api.controller;

import com.oceanview.ocean_view_resort.api.dto.UserDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.AuthService;
import com.oceanview.ocean_view_resort.api.service.impl.AuthServiceImpl;

/**
 * @author Batch_Top_Candidate
 * Pure Backend Controller - Cleaned from JavaFX dependencies.
 */
public class AuthController {
    private final AuthService authService = new AuthServiceImpl();



    private static UserDTO currentUser;

    public ResponseDTO<UserDTO> login(String username, String password) {
        try {
            UserDTO user = authService.login(username, password);
            if (user != null) {
                currentUser = user;
                return new ResponseDTO<>(200, "Login Success", user);
            }
            return new ResponseDTO<>(401, "Invalid Credentials", null);
        } catch (Exception e) {
            return new ResponseDTO<>(500, "Internal Server Error: " + e.getMessage(), null);
        }
    }


    public void logout() {
        currentUser = null;
        System.out.println("User Logged Out from the Session.");
    }

    public static UserDTO getCurrentUser() {
        return currentUser;
    }
}