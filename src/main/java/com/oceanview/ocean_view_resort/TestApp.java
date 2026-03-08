package com.oceanview.ocean_view_resort;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.dto.UserDTO;
import com.oceanview.ocean_view_resort.api.service.AuthService;
import com.oceanview.ocean_view_resort.api.service.BillingService;
import com.oceanview.ocean_view_resort.api.service.impl.AuthServiceImpl;
import com.oceanview.ocean_view_resort.api.service.impl.BillingServiceImpl;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("--- Ocean View Resort: Service Layer Testing ---");

        // 1. Checking the Authentication Service
        testAuth();

        // 2. Checking Billing Logic
        testBilling();
    }

    private static void testAuth() {
        AuthService authService = new AuthServiceImpl();
        try {
            // Enter the username/password from your DB here
            UserDTO user = authService.login("admin", "1234");
            if (user != null) {
                System.out.println("[SUCCESS] Login Work: Welcome " + user.getFullName());
            } else {
                System.out.println("[FAILED] Login Logic Work but User Not Found.");
            }
        } catch (Exception e) {
            System.err.println("[ERROR] Database Connection or DAO Error: " + e.getMessage());
        }
    }

    private static void testBilling() {
        BillingService billingService = new BillingServiceImpl();
        // Checking in for 3 nights and room rate 5000
        ResponseDTO<Double> response = billingService.calculateFinalBill(5000.0, 3);
        // Check if the StatusCode is 200 instead of response.isSuccess()
        if (response.getStatusCode() == 200) {
            System.out.println("[SUCCESS] Billing Logic Work: Total is " + response.getData());
        } else {
            System.out.println("[FAILED] Billing logic error: " + response.getMessage());
        }
    }
}