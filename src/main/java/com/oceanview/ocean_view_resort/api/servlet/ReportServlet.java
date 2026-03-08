package com.oceanview.ocean_view_resort.api.servlet;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.ReportService;
import com.oceanview.ocean_view_resort.api.service.impl.ReportServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReportServlet", value = "/api/report")
public class ReportServlet extends HttpServlet {
    private final ReportService reportService = new ReportServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));

        try {
            ResponseDTO<Double> income = reportService.getMonthlyIncome(month, year);
            response.getWriter().write("Monthly Income: " + income.getData());
        } catch (Exception e) {
            response.sendError(500, e.getMessage());
        }
    }
}
