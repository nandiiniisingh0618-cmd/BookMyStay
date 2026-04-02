import java.io.*;

/**
 * CLASS - PersistenceService
 * Handles Serialization and Deserialization of system state.
 * @version 12.0
 */
public class PersistenceService {

    private static final String FILE_NAME = "hotel_state.dat";

    /**
     * Saves the current inventory/history to a file.
     */
    public void saveState(Object state) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(state);
            System.out.println("System state persisted successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    /**
     * Loads the saved state from the file.
     */
    public Object loadState() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved state found. Starting fresh.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Recovery failed. Data might be corrupted: " + e.getMessage());
            return null;
        }
    }
}
