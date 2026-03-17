import java.util.Map;

/**
 * MAIN CLASS - UseCase3InventorySetup
 * This class demonstrates how room availability is managed using
 * a centralized inventory.
 * @version 3.0
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status\n");

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();
        Map<String, Integer> currentAvailability = inventory.getRoomAvailability();

        // Initialize Room objects (from Use Case 2)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Print Single Room Status
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + currentAvailability.get("Single Room") + "\n");

        // Print Double Room Status
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + currentAvailability.get("Double Room") + "\n");

        // Print Suite Room Status
        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + currentAvailability.get("Suite Room"));
    }
}