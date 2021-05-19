package util;

import model.SaleObs;
import model.Total;
import view.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public  class TotalRevenueFileOutput extends IOException implements SaleObs {

        private PrintWriter printWriter;


    public TotalRevenueFileOutput() throws IOException {
        FileWriter file = new FileWriter("IV_1350.TotRev.txt");
        printWriter = new PrintWriter(file, true);
    }

    private void logTotalRevenue(String message) {
        String formattedText = formatTotalRevenue(message);
        printWriter.println(formattedText);
    }

    private String formatTotalRevenue(String message) {
        return getTimeAndDate() +
                ";\n" + message;
    }

    private static String getTimeAndDate(){
        LocalDateTime now = LocalDateTime.now();
        return now.toLocalDate().toString();


}



    private String formatTotalPriceToText(Amount totalPrice) {
        return "Total inkomst: " + totalPrice.getAmount();
    }

    @Override
    public void updateTotal(Amount total) {
        String message = formatTotalPriceToText(total);
        logTotalRevenue(message);
    }
}