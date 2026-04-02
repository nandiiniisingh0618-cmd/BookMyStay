import java.util.Stack;
import java.util.Map;

/**
 * CLASS - CancellationService
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * Handles the safe reversal of system state using a Stack.
 * @version 10.0
 */
public class CancellationService {

    // Stack tracks released room IDs (LIFO) for potential audit or reuse
    private Stack<String> cancellationStack;

    public CancellationService() {
        this.cancellationStack = new Stack<>();
    }

    /**
     * Reverses a booking: Increments inventory and tracks the released ID.
     */
    public void cancelBooking(String roomId, String roomType, RoomInventory inventory) {
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // 1. Logic: Increment the inventory count
        int currentCount = availability.getOrDefault(roomType, 0);
        inventory.updateAvailability(roomType, currentCount + 1);

        // 2. Track the rollback in the stack
        cancellationStack.push(roomId);

        System.out.println("SUCCESS: Cancellation processed for " + roomId);
        System.out.println("Inventory for " + roomType + " restored to: " + (currentCount + 1));
    }

    public boolean hasRecentCancellations() {
        return !cancellationStack.isEmpty();
    }

    public String getLastCancelledRoom() {
        return cancellationStack.peek();
    }
}