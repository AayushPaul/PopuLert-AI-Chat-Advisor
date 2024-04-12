import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public abstract class OccupancyReporterTest {

    private OccupancyReporter reporter;

    @BeforeEach
    public void setUp() {
        reporter = new OccupancyReporter();
    }

    @Test
    public final void testReportOccupancy() {
        reporter.reportOccupancy("Location A", 10);
        assertEquals(10, reporter.getOccupancy("Location A"));
    }

    @Test
    public final void testGetOccupancy_LocationNotFound() {
        assertEquals(0, reporter.getOccupancy("Nonexistent Location"));
    }

    @Test
    public final void testGetLocations() {
        reporter.reportOccupancy("Location A", 10);
        reporter.reportOccupancy("Location B", 15);
        reporter.reportOccupancy("Location C", 20);
    
        String expectedOutput = "Locations: Location A, Location B, Location C, \n";
        assertEquals(expectedOutput, reporter.getLocations());
    }
    // Additional test cases can be added for comprehensive testing
}
