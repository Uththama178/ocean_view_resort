package com.oceanview.ocean_view_resort;

import com.oceanview.ocean_view_resort.util.DBConnection;
import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        try {

            Connection connection = DBConnection.getConnection();

            if (connection != null && !connection.isClosed()) {
                System.out.println("Database Connection Successful!");
                System.out.println("Connected to: " + connection.getMetaData().getURL());


                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }

}
