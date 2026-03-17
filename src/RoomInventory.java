import java.util.HashMap;
import java.util.Map;

/**
 * CLASS - RoomInventory
 * This class acts as the single source of truth for room availability.
 * @version 3.0
 */
public class RoomInventory {

    // Key -> Room type name, Value -> Available room count
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        this.roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Initializes room availability data instead of using scattered variables.
     */
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