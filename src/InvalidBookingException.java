/**
 * CUSTOM EXCEPTION - InvalidBookingException
 * Specifically for hotel booking business rule violations.
 */
public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
