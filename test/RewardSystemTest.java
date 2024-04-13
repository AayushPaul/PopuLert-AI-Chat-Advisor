
import org.junit.Test;

import static org.junit.Assert.*;


public class RewardSystemTest {
    private RewardSystem rewardSystem;
    

    // Test if a user can be added to the reward system
    @Test
    public void testAddUser() {
        rewardSystem = new RewardSystem();
        rewardSystem.addUser("Alice");
        assertEquals("Alice", rewardSystem.getUser("Alice").getUsername());
    }
    // Test if the system returns null when trying to get a user that does not exist
    @Test
    public void testGetUser_NotExist() {
        rewardSystem = new RewardSystem();
        assertNull(rewardSystem.getUser("Nonexistent User"));
    }
    // Test if coins can be added to a user's account
    @Test
    public void testAddCoins() {
        rewardSystem = new RewardSystem();
        rewardSystem.addUser("Alice");
        rewardSystem.addCoins("Alice", 100);
        assertEquals(100, rewardSystem.checkCoins("Alice"));
    }

    // test redeeming points
    @Test
    public void testRedeemPoints() {
        rewardSystem = new RewardSystem();
        rewardSystem.addUser("Alice");
        rewardSystem.addCoins("Alice", 100);
        rewardSystem.redeemPoints("Alice", 30);
        assertEquals(70, rewardSystem.checkCoins("Alice"));
    }



    @Test
    public void testCheckCoins() {
        rewardSystem = new RewardSystem();
        rewardSystem.addUser("Alice");
        assertEquals(0, rewardSystem.checkCoins("Alice"));
    }


}