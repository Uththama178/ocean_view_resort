package com.oceanview.ocean_view_resort.api.dao;

public interface ReportDAO {
    double getMonthlyIncome(int month, int year) throws Exception;
}