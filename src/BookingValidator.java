import java.util.Map;

/**
 * CLASS - BookingValidator
 * Implements Fail-Fast design by checking constraints before processing.
 * @version 9.0
 */
public class BookingValidator {

    /**
     * Validates if a booking request can be fulfilled.
     * @throws InvalidBookingException if room type is invalid or inventory is empty.
     */
    public void validate(Reservation reservation, RoomInventory inventory)
            throws InvalidBookingException {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // 1. Validate Room Type exists
        if (!availability.containsKey(roomType)) {
            throw new InvalidBookingException("Error: Room type '" + roomType + "' does not exist.");
        }

        // 2. Validate Inventory is not exhausted
        if (availability.get(roomType) <= 0) {
            throw new InvalidBookingException("Error: No inventory left for '" + roomType + "'.");
        }
    }
}
