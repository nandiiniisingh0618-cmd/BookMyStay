/**
 * MAIN CLASS - UseCase8HistoryAndReporting
 * Demonstrates historical tracking and administrative reporting.
 * @version 8.0
 */
public class UseCase8HistoryAndReporting {
    public static void main(String[] args) {
        // 1. Setup
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // 2. Simulate successful confirmations being recorded
        // (In a real app, these come from the AllocationService)
        history.recordBooking(new Reservation("Abhi", "Single Room"));
        history.recordBooking(new Reservation("Subha", "Double Room"));
        history.recordBooking(new Reservation("Vanmathi", "Suite Room"));

        // 3. Admin requests the report
        reportService.generateSummaryReport(history);
    }
}