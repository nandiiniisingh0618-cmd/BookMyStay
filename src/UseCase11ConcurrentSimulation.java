import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * MAIN CLASS - UseCase11ConcurrentSimulation
 * Demonstrates thread safety and prevention of race conditions.
 * @version 11.0
 */
public class UseCase11ConcurrentSimulation {
    public static void main(String[] args) {
        System.out.println("Starting Concurrent Booking Simulation...\n");

        // 1. Setup shared resources
        RoomInventory sharedInventory = new RoomInventory();
        BookingRequestQueue sharedQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // 2. Flood the queue with requests
        sharedQueue.addRequest(new Reservation("Guest_1", "Single Room"));
        sharedQueue.addRequest(new Reservation("Guest_2", "Single Room"));
        sharedQueue.addRequest(new Reservation("Guest_3", "Single Room"));
        sharedQueue.addRequest(new Reservation("Guest_4", "Single Room"));
        sharedQueue.addRequest(new Reservation("Guest_5", "Single Room"));

        // 3. Create a thread pool (Simulating 3 concurrent agents)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 4. Start processing
        for (int i = 0; i < 3; i++) {
            executor.execute(new ConcurrentBookingProcessor(sharedQueue, sharedInventory, allocationService));
        }

        // Shut down and wait for completion
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nSimulation complete. Final Inventory for Single Room: " +
                sharedInventory.getRoomAvailability().get("Single Room"));
    }
}