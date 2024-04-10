import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OccupancyReporter {
    private List<OccupancyReport> occupancyReports;

    public OccupancyReporter() {
        occupancyReports = new ArrayList<>();
    }

    public void reportOccupancy(String location, int occupancyLevel) {
        occupancyReports.add(new OccupancyReport(location, occupancyLevel));
        System.out.println("Occupancy level for " + location + " reported as: " + occupancyLevel);
    }

    public int getOccupancy(String location) {
        //search all the occupancy reports for the desired location
        for (OccupancyReport report : occupancyReports) {
            if (report.getLocation().equals(location)) {
                return report.getOccupancyLevel();
            }
        }
        // Default to 0 if location not found
        return 0;
    }

    public void getLocations() {
        //Print all the locations in the list of reports
        System.out.print("Locations: ");
        for (OccupancyReport report : occupancyReports) {
            System.out.print(report.getLocation() + ", ");
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {
        OccupancyReporter reporter = new OccupancyReporter();
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option !=3) {
            System.out.println("1. Report occupancy level");
            System.out.println("2. Check occupancy level");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            // buffer since input switches from int to string
            scanner.nextLine();
            System.out.print("\n\n\n");
            switch (option) {
                case 1:
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter occupancy level: ");
                    int occupancy = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    reporter.reportOccupancy(location, occupancy);
                    System.out.print("\n\n\n");
                    break;
                case 2:
                    System.out.print("Enter location to check occupancy: \n");
                    reporter.getLocations();
                    String locationToCheck = scanner.nextLine();
                    int currentOccupancy = reporter.getOccupancy(locationToCheck);
                    System.out.print("\n");
                    if(currentOccupancy == 0){
                        System.out.print("That Location has not been reported yet");
                    }else{
                        System.out.println("Current occupancy level at " + locationToCheck + " is: " + currentOccupancy);  
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
                    break;
            }
        }
    }
}
