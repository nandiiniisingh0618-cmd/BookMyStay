import java.util.ArrayList;
import java.util.List;

/**
 * CLASS - BookingHistory
 * Use Case 8: Booking History & Reporting
 * Maintains a chronological record of all confirmed reservations.
 * @version 8.0
 */
public class BookingHistory {
    // List preserves the order of confirmation
    private List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }

    /**
     * Adds a confirmed reservation to the history log.
     */
    public void recordBooking(Reservation reservation) {
        history.add(reservation);
    }

    /**
     * Returns the full list of historical bookings.
     */
    public List<Reservation> getHistory() {
        // Returning a copy or the list for read-only access
        return new ArrayList<>(history);
    }
}