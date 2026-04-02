import java.io.Serializable; // 1. Add this import
import java.util.HashMap;
import java.util.Map;

/**
 * CLASS - RoomInventory
 * Updated for Use Case 12: Data Persistence
 * @version 12.0
 */
public class RoomInventory implements Serializable { // 2. Add 'implements Serializable'

    // 3. Add the serialVersionUID
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        this.roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}