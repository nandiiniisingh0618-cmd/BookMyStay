/**
 * MAIN CLASS - UseCase9ValidationHandling
 * Demonstrates early detection of errors and system stability.
 * @version 9.0
 */
public class UseCase9ValidationHandling {
    public static void main(String[] args) {
        System.out.println("Booking Validation & Error Handling\n");

        RoomInventory inventory = new RoomInventory();
        BookingValidator validator = new BookingValidator();

        // Scenario 1: Valid Booking
        processBooking(new Reservation("Abhi", "Single Room"), inventory, validator);

        // Scenario 2: Invalid Room Type (Typo in input)
        processBooking(new Reservation("Subha", "Penthouse"), inventory, validator);

        // Scenario 3: Inventory Exhaustion
        // (Pre-emptively setting Suite Room to 0 to test)
        inventory.updateAvailability("Suite Room", 0);
        processBooking(new Reservation("Vanmathi", "Suite Room"), inventory, validator);

        System.out.println("\nSystem remains stable and continues running.");
    }

    private static void processBooking(Reservation res, RoomInventory inv, BookingValidator val) {
        try {
            val.validate(res, inv);
            System.out.println("Validation Passed for: " + res.getGuestName());
        } catch (InvalidBookingException e) {
            // Graceful handling: catch the exception and print the message
            System.err.println("Validation Failed: " + e.getMessage());
        }
    }
}
