package com.oceanview.ocean_view_resort.api.servlet;

import com.oceanview.ocean_view_resort.api.dto.ReservationDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.ReservationService;
import com.oceanview.ocean_view_resort.api.service.impl.ReservationServiceImpl;

import com.oceanview.ocean_view_resort.model.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Batch_Top_Candidate
 * නිවැරදි කරන ලද Reservation Servlet.
 * පරාමිතීන් 7ක් පාලනය කිරීම සහ Logic සම්බන්ධ කිරීම මෙහි සිදු වේ.
 */
@WebServlet(name = "ReservationServlet", urlPatterns = "/api/reservation")
public class ReservationServlet extends HttpServlet {

    // Service Layer එක සම්බන්ධ කිරීම
    private final ReservationService reservationService = new ReservationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            // UI එකෙන් එන දත්ත ලබා ගැනීම
            String resId = request.getParameter("resId");
            String guestId = request.getParameter("guestId");
            String roomId = request.getParameter("roomId");
            String checkIn = request.getParameter("checkIn");
            String checkOut = request.getParameter("checkOut");
            String totalAmountStr = request.getParameter("totalAmount");

            // Validation: අත්‍යවශ්‍ය දත්ත තිබේදැයි බැලීම
            if (resId == null || guestId == null || totalAmountStr == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"Missing required fields!\"}");
                return;
            }

            // DTO එක සකස් කිරීම
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setResId(resId);
            reservationDTO.setGuestId(guestId);
            reservationDTO.setRoomId(roomId);
            reservationDTO.setCheckIn(checkIn);
            reservationDTO.setCheckOut(checkOut);
            reservationDTO.setTotalAmount(Double.parseDouble(totalAmountStr));

            // Service එක හරහා දත්ත ගබඩා කිරීම
            ResponseDTO<Boolean> result = reservationService.confirmBooking(reservationDTO);

            // ප්‍රතිඵලය JSON එකක් ලෙස යැවීම
            response.setStatus(result.getCode());
            response.getWriter().write("{\"message\": \"" + result.getMessage() + "\", \"status\": " + result.getData() + "}");

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid format for Total Amount!\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Server Error: " + e.getMessage() + "\"}");
        }
    }

    // ReservationServlet.java තුළ
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            List<Reservation> all = reservationService.getAll();
            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < all.size(); i++) {
                Reservation r = all.get(i);
                json.append("{");
                json.append("\"resId\":\"").append(r.getResId()).append("\",");
                json.append("\"guestId\":\"").append(r.getGuestId()).append("\",");
                json.append("\"roomId\":\"").append(r.getRoomId()).append("\",");
                json.append("\"checkIn\":\"").append(r.getCheckIn()).append("\",");
                json.append("\"status\":\"").append(r.getStatus()).append("\",");
                json.append("\"amount\":").append(r.getTotalAmount()); // මෙතැන "amount" ලෙසම තිබිය යුතුයි
                json.append("}");
                if (i < all.size() - 1) json.append(",");
            }
            json.append("]");
            response.getWriter().write(json.toString());
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().write("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}