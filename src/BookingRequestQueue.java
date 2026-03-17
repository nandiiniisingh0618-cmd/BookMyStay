import java.util.LinkedList;
import java.util.Queue;

/**
 * CLASS - BookingRequestQueue
 * Manages booking requests using a FIFO queue to ensure fair allocation.
 * @version 5.0
 */
public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        this.requestQueue = new LinkedList<>();
    }

    /** Adds a request to the end of the line */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /** Retrieves and removes the next request in line */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /** Checks if there are requests waiting */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}
