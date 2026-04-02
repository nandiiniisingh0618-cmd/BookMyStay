import java.util.Map;

/**
 * MAIN CLASS - UseCase12PersistenceRecovery
 * Demonstrates system recovery after an application restart.
 */
public class UseCase12PersistenceRecovery {
    public static void main(String[] args) {
        PersistenceService persistence = new PersistenceService();
        RoomInventory inventory;

        System.out.println("--- System Startup ---");

        // 1. Attempt Recovery
        Object recovered = persistence.loadState();
        if (recovered instanceof RoomInventory) {
            inventory = (RoomInventory) recovered;
            System.out.println("Recovery Successful!");
        } else {
            inventory = new RoomInventory(); // Start fresh if no file
        }

        // 2. Modify State (Simulate a booking)
        System.out.println("Current Single Rooms: " + inventory.getRoomAvailability().get("Single Room"));
        inventory.updateAvailability("Single Room", 10); // Update to a new value
        System.out.println("Updated Single Rooms to 10 for testing persistence.");

        // 3. Persist and "Shutdown"
        System.out.println("\n--- System Shutdown ---");
        persistence.saveState(inventory);

        System.out.println("\nRun this program again to see the value '10' persist!");
    }
}