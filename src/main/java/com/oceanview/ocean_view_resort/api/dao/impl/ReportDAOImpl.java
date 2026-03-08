package com.oceanview.ocean_view_resort.api.dao.impl;

import com.oceanview.ocean_view_resort.api.dao.ReportDAO;
import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAOImpl implements ReportDAO {

    @Override
    public double getMonthlyIncome(int month, int year) throws Exception {
        // SQL Query එක: පවතින reservation වගුවේ total_amount එකතු කිරීම
        String sql = "SELECT SUM(total_amount) AS monthly_income FROM reservation " +
                "WHERE MONTH(checkIn) = ? AND YEAR(checkIn) = ?";

        // Singleton Pattern එක හරහා Connection එක ලබා ගැනීම [cite: 2026-02-14]
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setInt(1, month);
            pstm.setInt(2, year);

            ResultSet rst = pstm.executeQuery();

            if (rst.next()) {
                // DB එකේ දත්ත තිබේ නම් එම අගය ලබා දෙයි
                return rst.getDouble("monthly_income");
            }
        }
        return 0.0; // දත්ත නැතිනම් 0.0 ලබා දෙයි
    }
}