

import static org.junit.Assert.assertEquals;

import org.junit.Test;



public  class OccupancyReporterTest {

    private OccupancyReporter reporter;
    // Test to check if the reportOccupancy method correctly reports the occupancy for a given location
    @Test
    public final void testReportOccupancy() {
        reporter = new OccupancyReporter();
        reporter.reportOccupancy("Location A", 10);
        assertEquals(10, reporter.getOccupancy("Location A"));
    }

    // Test to check if the getOccupancy method returns 0 for a location that does not exist
    @Test
    public final void testGetOccupancy_LocationNotFound() {
        reporter = new OccupancyReporter();
        assertEquals(0, reporter.getOccupancy("Nonexistent Location"));
    }
    // Test to check if the getLocations method correctly returns all the locations for which occupancy has been reported  
    @Test
    public final void testGetLocations() {
        reporter = new OccupancyReporter();
        reporter.reportOccupancy("Location A", 10);
        reporter.reportOccupancy("Location B", 15);
        reporter.reportOccupancy("Location C", 20);
    
        String expectedOutput = "Locations: Location A, Location B, Location C, \n";
        assertEquals(expectedOutput, reporter.getLocations());
    }
}
