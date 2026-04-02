/**
 * MAIN CLASS - UseCase7AddOnSelection
 * Demonstrates business extensibility using Map and List.
 * @version 7.0
 */
public class UseCase7AddOnSelection {
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection\n");

        // Assume Use Case 6 has already run and we have a Room ID
        String assignedRoomId = "Suite Room-1";

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Guest selects services
        serviceManager.addService(assignedRoomId, new Service("Breakfast Buffet", 500.0));
        serviceManager.addService(assignedRoomId, new Service("Late Check-out", 1000.0));
        serviceManager.addService(assignedRoomId, new Service("Airport Pickup", 1500.0));

        // Display results
        System.out.println("\nSummary for " + assignedRoomId + ":");
        for (Service s : serviceManager.getServices(assignedRoomId)) {
            System.out.println("- " + s.getServiceName() + ": " + s.getPrice());
        }

        double total = serviceManager.calculateTotalAddOnCost(assignedRoomId);
        System.out.println("Total Add-On Cost: " + total);
    }
}