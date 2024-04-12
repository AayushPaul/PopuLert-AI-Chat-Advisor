public class OccupancyReport {
    private String location;
    private int occupancyLevel;

    public OccupancyReport(String location, int occupancyLevel) {
        this.location = location;
        this.occupancyLevel = occupancyLevel;
    }

    public String getLocation() {
        return location;
    }

    public int getOccupancyLevel() {
        return occupancyLevel;
    }
}
