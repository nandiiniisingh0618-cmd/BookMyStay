import java.util.*;

/**
 * CLASS - RoomAllocationService
 * Use Case 6: Reservation Confirmation & Room Allocation
 * Responsible for confirming booking requests and assigning unique rooms.
 * @version 6.0
 */
public class RoomAllocationService {

    // Stores all allocated room IDs to prevent duplicate assignments
    private Set<String> allocatedRoomIds;

    // Maps room types to their specific set of assigned room IDs
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        this.allocatedRoomIds = new HashSet<>();
        this.assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking by assigning a unique ID and updating inventory.
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check if rooms are available in the inventory
        if (availability.getOrDefault(type, 0) > 0) {
            String roomId = generateRoomId(type);

            // Ensure uniqueness via the Set
            allocatedRoomIds.add(roomId);

            // Map the room to its type category
            assignedRoomsByType.computeIfAbsent(type, k -> new HashSet<>()).add(roomId);

            // Immediate Inventory Synchronization: Decrement the count
            inventory.updateAvailability(type, availability.get(type) - 1);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for " + reservation.getGuestName() +
                    ": No " + type + " rooms available.");
        }
    }

    /**
     * Generates a unique room ID based on type and current set size.
     */
    private String generateRoomId(String roomType) {
        int nextId = assignedRoomsByType.getOrDefault(roomType, new HashSet<>()).size() + 1;
        return roomType + "-" + nextId;
    }
}
