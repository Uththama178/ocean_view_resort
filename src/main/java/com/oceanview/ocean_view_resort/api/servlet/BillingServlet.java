package com.oceanview.ocean_view_resort.api.servlet;



import com.oceanview.ocean_view_resort.api.dto.BillDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.BillingService;
import com.oceanview.ocean_view_resort.api.service.impl.BillingServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BillingServlet", value = "/api/billing")
public class BillingServlet extends HttpServlet {
    private final BillingService billingService = new BillingServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try {
            String billId = request.getParameter("billId");
            String resId = request.getParameter("resId");
            double total = Double.parseDouble(request.getParameter("totalAmount"));
            double discount = Double.parseDouble(request.getParameter("discount"));
            double finalAmount = total - discount;

            BillDTO billDTO = new BillDTO(billId, resId, total, discount, finalAmount);
            ResponseDTO<Boolean> result = billingService.saveBill(billDTO);

            response.getWriter().write("{\"status\":" + result.getData() + ", \"message\":\"" + result.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
            response.getWriter().write("{\"status\":false, \"message\":\"" + e.getMessage() + "\"}");
        }
    }

    // පැරණි doGet එක (Calculation සඳහා)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rateStr = request.getParameter("rate");
        String nightsStr = request.getParameter("nights");

        // පරාමිතීන් හිස් දැයි පරීක්ෂා කිරීම
        if (rateStr == null || rateStr.isEmpty() || nightsStr == null || nightsStr.isEmpty()) {
            response.setStatus(400); // Bad Request
            response.getWriter().write("Error: Parameters Missing");
            return;
        }

        try {
            double rate = Double.parseDouble(rateStr);
            int nights = Integer.parseInt(nightsStr);

            ResponseDTO<Double> bill = billingService.calculateFinalBill(rate, nights);
            response.getWriter().write(String.valueOf(bill.getData()));

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.setStatus(400);
            response.getWriter().write("Invalid numeric input");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.getMessage());
        }
    }
}
