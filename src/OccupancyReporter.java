import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents an Occupancy Reporter that allows users to report and check occupancy levels for different locations.
 */
public class OccupancyReporter {
    // List to store occupancy reports
    private List<OccupancyReport> occupancyReports; 

    /**
     * Initializes the OccupancyReporter object.
     * Requires: None
     * Ensures: An instance of OccupancyReporter is created with an empty list of occupancy reports.
     */
    public OccupancyReporter() {
        occupancyReports = new ArrayList<>();
    }

    /**
     * Method to report the occupancy level for a location.
     *
     * @param location       The location for which occupancy is reported.
     * @param occupancyLevel The level of occupancy reported.
     * Requires: location must not be null.
     * Ensures: A new OccupancyReport is created and added to the list of occupancy reports.
     */
    public void reportOccupancy(String location, int occupancyLevel) {
        // Create new OccupancyReport and add to list
        occupancyReports.add(new OccupancyReport(location, occupancyLevel)); 
        //print the location and level
        System.out.println("Occupancy level for " + location + " reported as: " + occupancyLevel);
    }

    /**
     * Method to get the occupancy level for a specific location.
     *
     * @param location The location for which occupancy level is requested.
     * @return The occupancy level for the specified location. Returns 0 if location not found.
     * Requires: location must not be null.
     * Ensures: Returns the occupancy level of the specified location.
     */
    public int getOccupancy(String location) {
        // Search all the occupancy reports for the desired location
        for (OccupancyReport report : occupancyReports) {
            if (report.getLocation().equals(location)) {
                return report.getOccupancyLevel();
            }
        }
        // Default to 0 if location not found
        return 0;
    }

    /**
     * Method to print all the locations that have occupancy reports.
     * Requires: None
     * Ensures: Prints all the locations in the list of reports.
     */
    public String getLocations() {
        // return all the locations in the list of reports
        StringBuilder locations = new StringBuilder("Locations: ");
    for (OccupancyReport report : occupancyReports) {
        locations.append(report.getLocation()).append(", ");
    }
    locations.append("\n");
    return locations.toString();

    }

    /**
     * Main method to execute the Occupancy Reporter application.
     *
     * @param args Command line arguments (not used in this program).
     * Requires: None
     * Ensures: The Occupancy Reporter application is executed.
     */
    public static void main(String[] args) {
        OccupancyReporter reporter = new OccupancyReporter();
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 3) {
            System.out.println("\n1. Report occupancy level");
            System.out.println("2. Check occupancy level");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            // Buffer since input switches from int to string
            scanner.nextLine();
            System.out.print("\n\n\n");
            switch (option) {
                case 1:
                    //ask for location and occupancy level
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine().trim();
                    System.out.print("Enter occupancy level: ");
                    int occupancy = scanner.nextInt();
                    // Buffer since input switches from int to string
                    scanner.nextLine();
                    reporter.reportOccupancy(location, occupancy);
                    System.out.print("\n\n\n");
                    break;
                case 2:
                    //ask for location to check
                    System.out.print("Enter location to check occupancy: \n");
                    System.out.print(reporter.getLocations());
                    String locationToCheck = scanner.nextLine().trim();
                    // set occupency to the last reported level
                    int currentOccupancy = reporter.getOccupancy(locationToCheck);
                    System.out.print("\n");
                    
                    if (currentOccupancy == 0) {
                        System.out.print("That Location has not been reported yet");
                    } else {
                        System.out.println("Current occupancy level at " + locationToCheck + " is: "
                                + currentOccupancy);
                    }
                    System.out.print("\n\n\n");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
