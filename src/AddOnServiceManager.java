import java.util.*;

/**
 * CLASS - AddOnServiceManager
 * Manages the mapping between allocated rooms and their optional services.
 * @version 7.0
 */
public class AddOnServiceManager {

    // Map of RoomID -> List of Services (One-to-Many)
    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {
        this.reservationServices = new HashMap<>();
    }

    /**
     * Adds a service to a specific room allocation.
     */
    public void addService(String roomId, Service service) {
        reservationServices.computeIfAbsent(roomId, k -> new ArrayList<>()).add(service);
        System.out.println("Service '" + service.getServiceName() + "' added to " + roomId);
    }

    /**
     * Calculates the total cost of all add-ons for a specific room.
     */
    public double calculateTotalAddOnCost(String roomId) {
        List<Service> services = reservationServices.get(roomId);
        if (services == null) return 0.0;

        return services.stream().mapToDouble(Service::getPrice).sum();
    }

    public List<Service> getServices(String roomId) {
        return reservationServices.getOrDefault(roomId, new ArrayList<>());
    }
}
