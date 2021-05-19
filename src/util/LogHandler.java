package util;

import java.time.LocalDateTime;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogHandler extends IOException {
    private final PrintWriter logWriter;

    public LogHandler() throws IOException {
        FileWriter file = new FileWriter("iv1350_errors_logg");
        logWriter = new PrintWriter(file, true);
    }

    /**
     * loggar det påhittade exceptions i en fil.
     *
     * @param exception the caught exception.
     */
    public void logException(Exception exception) {
        String builder = formatExceptionMessage(exception);
        logWriter.println(builder);
    }

    private String formatExceptionMessage(Exception exception) {
        return currentTime() +
                ";\nDe exeption som på träffat är: \nException medelande: " +
                exception.getMessage() +
                "\nStack trace: " +
                Arrays.toString(exception.getStackTrace());
    }

    private String currentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        return OffsetDateTime.now().format(formatter);
    }



}


