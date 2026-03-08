package com.oceanview.ocean_view_resort.api.service.impl;
import com.oceanview.ocean_view_resort.api.dao.BillDAO;
import com.oceanview.ocean_view_resort.api.dao.impl.BillDAOImpl;
import com.oceanview.ocean_view_resort.api.dto.BillDTO;
import com.oceanview.ocean_view_resort.api.dto.ResponseDTO;
import com.oceanview.ocean_view_resort.api.service.BillingService;
import com.oceanview.ocean_view_resort.model.Bill;
import java.sql.Timestamp;

public class BillingServiceImpl implements BillingService {

    private final BillDAO billDAO = new BillDAOImpl();

    @Override
    public ResponseDTO<Double> calculateFinalBill(double rate, int nights) {
        if (nights < 1) return new ResponseDTO<>(400, "Invalid duration", 0.0);
        double total = rate * nights;
        return new ResponseDTO<>(200, "Calculation Successful", total);
    }

    @Override
    public ResponseDTO<Boolean> saveBill(BillDTO billDTO) {
        try {
            // DTO..........>Model
            Bill bill = new Bill(
                    billDTO.getBillId(),
                    billDTO.getResId(),
                    billDTO.getFinalAmount(),
                    new Timestamp(System.currentTimeMillis()) // Time now
            );

            boolean isSaved = billDAO.save(bill);

            if (isSaved) {
                return new ResponseDTO<>(201, "Bill Saved Successfully!", true);
            }
            return new ResponseDTO<>(400, "Failed to Save Bill", false);

        } catch (Exception e) {
            return new ResponseDTO<>(500, "Internal Error: " + e.getMessage(), false);
        }
    }
}
