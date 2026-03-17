/**
 * MAIN CLASS - UseCase4RoomSearch
 * Demonstrates how guests can view available rooms without modifying state.
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {
        System.out.println("Room Search\n");

        // Initialize Data Layer
        RoomInventory inventory = new RoomInventory();

        // Initialize Domain Models
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Initialize Search Service
        RoomSearchService searchService = new RoomSearchService();

        // Execute Search (Read-Only)
        searchService.searchAvailableRooms(inventory, single, doubleRoom, suite);
    }
}