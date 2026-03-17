/**
 * MAIN CLASS - UseCase6RoomAllocation
 * This class demonstrates the safety of the allocation process.
 * @version 6.0
 */
public class UseCase6RoomAllocation {

    public static void main(String[] args) {
        System.out.println("Room Allocation Processing\n");

        // 1. Setup Data Layers
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // 2. Add Requests to Queue (From Use Case 5)
        queue.addRequest(new Reservation("Abhi", "Single Room"));
        queue.addRequest(new Reservation("Subha", "Single Room"));
        queue.addRequest(new Reservation("Vanmathi", "Suite Room"));

        // 3. Process the Queue in FIFO order
        while (queue.hasPendingRequests()) {
            Reservation request = queue.getNextRequest();
            allocationService.allocateRoom(request, inventory);
        }
    }
}
