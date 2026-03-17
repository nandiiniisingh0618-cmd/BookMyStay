/**
 * MAIN CLASS - UseCase3InventorySetup
 * Demonstrates centralized inventory management using HashMap.
 * @version 3.0
 */
public class UseCase3InventorySetup {
    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status\n");

        // Initialize the centralized inventory
        RoomInventory inventory = new RoomInventory();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Create Room objects to get their intrinsic characteristics
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Displaying data by combining Room details + Inventory counts
        displayStatus("Single Room", single, availability.get("Single Room"));
        displayStatus("Double Room", doubleRoom, availability.get("Double Room"));
        displayStatus("Suite Room", suite, availability.get("Suite Room"));
    }

    private static void displayStatus(String label, Room room, int count) {
        System.out.println(label + ":");
        room.displayRoomDetails();
        System.out.println("Available Rooms: " + count + "\n");
    }
}