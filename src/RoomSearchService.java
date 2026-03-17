import java.util.Map;

/**
 * CLASS - RoomSearchService
 * Use Case 4: Room Search & Availability Check
 * This class provides search functionality for guests to view available rooms.
 * @version 4.0
 */
public class RoomSearchService {

    /**
     * Displays available rooms along with their details and pricing.
     * Performs read-only access to inventory and room data.
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("--- Available Rooms ---");

        // Check and display Single Room
        if (availability.getOrDefault("Single Room", 0) > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Single Room") + "\n");
        }

        // Check and display Double Room
        if (availability.getOrDefault("Double Room", 0) > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Double Room") + "\n");
        }

        // Check and display Suite Room
        if (availability.getOrDefault("Suite Room", 0) > 0) {
            System.out.println("Suite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Suite Room") + "\n");
        }
    }
}
