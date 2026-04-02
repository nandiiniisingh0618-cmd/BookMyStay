/**
 * MAIN CLASS - UseCase10CancellationRollback
 * Demonstrates state reversal and LIFO rollback logic.
 * @version 10.0
 */
public class UseCase10CancellationRollback {
    public static void main(String[] args) {
        System.out.println("Booking Cancellation System\n");

        // 1. Setup existing state
        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Assume a "Suite Room" was booked (current count is 2 in Use Case 3)
        String roomToCancel = "Suite Room-1";
        String type = "Suite Room";

        System.out.println("Initial Inventory for " + type + ": " +
                inventory.getRoomAvailability().get(type));

        // 2. Perform Cancellation
        System.out.println("\nInitiating cancellation for: " + roomToCancel + "...");
        cancellationService.cancelBooking(roomToCancel, type, inventory);

        // 3. Verify Rollback
        if (cancellationService.hasRecentCancellations()) {
            System.out.println("\nRecent Rollback Activity:");
            System.out.println("Last room returned to pool: " + cancellationService.getLastCancelledRoom());
        }
    }
}