package com.oceanview.ocean_view_resort.api.service.impl;

import com.oceanview.ocean_view_resort.api.dao.UserDAO;
import com.oceanview.ocean_view_resort.api.dao.impl.UserDAOImpl;
import com.oceanview.ocean_view_resort.api.dto.UserDTO;
import com.oceanview.ocean_view_resort.model.User;
import com.oceanview.ocean_view_resort.api.service.AuthService;

/**
 * Service Implementation for Authentication logic.
 * Adheres to Java EE design patterns and SOLID principles. [cite: 2026-02-14]
 */
public class AuthServiceImpl implements AuthService {

    // Dependency Injection: Connecting to the DAO Layer [cite: 2026-02-14]
    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public UserDTO login(String username, String password) throws Exception {
        // Corrected: Using 'findByUsername' as defined in your UserDAO
        User user = userDAO.findByUsername(username);

        // Validating user existence and password match
        if (user != null && user.getPassword().equals(password)) {

            // Corrected: Using UserDTO constructor with 5 parameters
            // Mapping Model 'fullName' to DTO 'fullName'
            return new UserDTO(
                    user.getUserId(),
                    user.getUsername(),
                    null, // Security: Do not send password back to UI
                    user.getRole(),
                    user.getFullName()
            );
        }

        // Return null if authentication fails
        return null;
    }
}
