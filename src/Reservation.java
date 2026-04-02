import java.io.Serializable; // 1. Add the import at the very top

/**
 * CLASS - Reservation
 * Represents a booking request made by a guest.
 * @version 5.0
 */
public class Reservation implements Serializable { // 2. Add 'implements Serializable' here

    // 3. Add the ID right at the top of the class body
    private static final long serialVersionUID = 1L;

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}