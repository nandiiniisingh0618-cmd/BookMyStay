import java.util.List;

/**
 * CLASS - BookingReportService
 * Generates summaries and reports from the BookingHistory.
 * @version 8.0
 */
public class BookingReportService {

    /**
     * Prints a formatted report of all bookings to the console.
     */
    public void generateSummaryReport(BookingHistory bookingHistory) {
        List<Reservation> records = bookingHistory.getHistory();

        System.out.println("========== ADMINISTRATIVE BOOKING REPORT ==========");
        System.out.println("Total Bookings Processed: " + records.size());
        System.out.println("--------------------------------------------------");

        if (records.isEmpty()) {
            System.out.println("No history found.");
        } else {
            for (int i = 0; i < records.size(); i++) {
                Reservation res = records.get(i);
                System.out.println((i + 1) + ". Guest: " + res.getGuestName() +
                        " | Room Type: " + res.getRoomType());
            }
        }
        System.out.println("==================================================\n");
    }
}