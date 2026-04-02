/**
 * CLASS - ConcurrentBookingProcessor
 * Use Case 11: Concurrent Booking Simulation (Thread Safety)
 * Processes booking requests from multiple threads safely.
 */
public class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue queue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue queue,
                                      RoomInventory inventory,
                                      RoomAllocationService allocationService) {
        this.queue = queue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (queue.hasPendingRequests()) {
            Reservation request = queue.getNextRequest();
            if (request != null) {
                // CRITICAL SECTION: Only one thread can enter this block at a time
                synchronized (inventory) {
                    System.out.println(Thread.currentThread().getName() +
                            " is processing request for: " + request.getGuestName());
                    allocationService.allocateRoom(request, inventory);
                }
            }

            // Artificial delay to simulate network latency
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}