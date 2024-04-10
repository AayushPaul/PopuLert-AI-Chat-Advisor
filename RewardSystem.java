import java.util.HashMap;
import java.util.Map;

public class RewardSystem {
    private Map<String, User> users;

    public RewardSystem() {
        this.users = new HashMap<>();
    }

    public void addUser(String username) {
        this.users.put(username, new User(username));
    }

    public User getUser(String username) {
        return this.users.get(username);
    }

    public void addCoins(String username, int coins) {
        User user = this.users.get(username);
        if (user != null) {
            user.addCoins(coins);
        } else {
            System.out.println("User " + username + " does not exist.");
        }
    }

    public void redeemPoints(String username, int points) {
        User user = this.users.get(username);
        if (user != null) {
            user.redeemPoints(points);
        } else {
            System.out.println("User " + username + " does not exist.");
        }
    }

    public int checkCoins(String username) {
        User user = this.users.get(username);
        if (user != null) {
            return user.getCoins();
        } else {
            System.out.println("User " + username + " does not exist.");
            return -1;
        }
    }

    public static void main(String[] args) {
        RewardSystem rewardSystem = new RewardSystem();
    
        // Add users
        rewardSystem.addUser("Alice");
        rewardSystem.addUser("Bob");
    
        // Add coins
        rewardSystem.addCoins("Alice", 100);
        rewardSystem.addCoins("Bob", 50);
    
        // Check coins
        System.out.println("Alice has " + rewardSystem.checkCoins("Alice") + " coins.");
        System.out.println("Bob has " + rewardSystem.checkCoins("Bob") + " coins.");
    
        // Redeem points
        rewardSystem.redeemPoints("Alice", 30);
        rewardSystem.redeemPoints("Bob", 60);
    
        // Check coins again
        System.out.println("Alice has " + rewardSystem.checkCoins("Alice") + " coins.");
        System.out.println("Bob has " + rewardSystem.checkCoins("Bob") + " coins.");
    }
}