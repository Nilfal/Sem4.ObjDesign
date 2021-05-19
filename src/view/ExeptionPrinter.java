package view;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ExeptionPrinter {
    /**

     * Printar till displayen det error medelandet som är påhittat.
     * @param message caught error message.
     */
    public void print(String message) {
        System.out.println(formatExceptionMessage(message));
    }

    private String formatExceptionMessage(String message) {
        return currentTime() +
                "; \nDe exeption som på träffat är : \nExeption medelande: " +
                message;
    }

    private String currentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
        return OffsetDateTime.now().format(formatter);
    }
}