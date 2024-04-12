import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RewardSystemTest {
    private RewardSystem rewardSystem;

    @BeforeEach
    public void setUp() {
        rewardSystem = new RewardSystem();
    }

    @Test
    public void testAddUser() {
        rewardSystem.addUser("Alice");
        assertEquals("Alice", rewardSystem.getUser("Alice").getUsername());
    }

    @Test
    public void testGetUser_NotExist() {
        assertNull(rewardSystem.getUser("Nonexistent User"));
    }

    @Test
    public void testAddCoins() {
        rewardSystem.addUser("Alice");
        rewardSystem.addCoins("Alice", 100);
        assertEquals(100, rewardSystem.checkCoins("Alice"));
    }


    @Test
    public void testRedeemPoints() {
        rewardSystem.addUser("Alice");
        rewardSystem.addCoins("Alice", 100);
        rewardSystem.redeemPoints("Alice", 30);
        assertEquals(70, rewardSystem.checkCoins("Alice"));
    }



    @Test
    public void testCheckCoins() {
        rewardSystem.addUser("Alice");
        assertEquals(0, rewardSystem.checkCoins("Alice"));
    }


}