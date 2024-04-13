/**
 * Class representing an occupancy report.
 */
public class OccupancyReport {
    private String location;
    private int occupancyLevel;

    /**
     * Constructor for OccupancyReport.
     * @param location The location for the report.
     * @param occupancyLevel The occupancy level for the report.
     * @Requires: location is not null and occupancyLevel is a non-negative integer.
     * @Ensures: A new OccupancyReport object is created with the given location and occupancy level.
     */
    public OccupancyReport(String location, int occupancyLevel) {
        this.location = location;
        this.occupancyLevel = occupancyLevel;
    }

    /**
     * Method to get the location of the report.
     * @return The location of the report.
     * @Ensures: The location of the report is returned.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Method to get the occupancy level of the report.
     * @return The occupancy level of the report.
     * @Ensures: The occupancy level of the report is returned.
     */
    public int getOccupancyLevel() {
        return occupancyLevel;
    }
}