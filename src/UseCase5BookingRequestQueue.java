/**
 * MAIN CLASS - UseCase5BookingRequestQueue
 * Demonstrates the First-Come-First-Served booking intent.
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        System.out.println("Booking Request Queue\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate guests submitting requests
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Process requests in order
        while (bookingQueue.hasPendingRequests()) {
            Reservation res = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: " + res.getGuestName() +
                    ", Room Type: " + res.getRoomType());
        }
    }
}
