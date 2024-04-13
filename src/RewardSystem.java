import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Class to manage the reward system.
 */
public class RewardSystem {
    /**
     * Map to store users with their usernames as keys.
     */
    private Map<String, User> users;

    /**
     * Constructor initializes the users map.
     */
    public RewardSystem() {
        this.users = new HashMap<>();
    }

    /**
     * Method to add a new user to the system.
     * @param username The username of the user to be added.
     * @Requires: username is not null.
     * @Ensures: A new user with the given username is added to the system.
     */
    public void addUser(String username) {
        this.users.put(username, new User(username));
    }


    /**
     * Method to get a user from the system.
     * @param username The username of the user to be retrieved.
     * @Requires: username is not null.
     * @Ensures: The user with the given username is returned, or null if no such user exists.
     */
    public User getUser(String username) {
        return this.users.get(username);
    }

    /**
     * Method to add coins to a user's account.
     * @param username The username of the user.
     * @param coins The number of coins to be added.
     * @Requires: username is not null and coins is a positive integer.
     * @Ensures: The specified number of coins are added to the user's account, or a message is printed if no such user exists.
     */
    public void addCoins(String username, int coins) {
        User user = this.users.get(username);
        //if the user exists then add the coins
        if (user != null) {
            user.addCoins(coins);
        } else {
            System.out.println("User " + username + " does not exist.");
        }
    }

    /**
     * Method to redeem points from a user's account.
     * @param username The username of the user.
     * @param points The number of points to be redeemed.
     * @Requires: username is not null and points is a positive integer.
     * @Ensures: The specified number of points are redeemed from the user's account, or a message is printed if no such user exists.
     */
    public void redeemPoints(String username, int points) {
        User user = this.users.get(username);
        //if the user exists redeem points
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
            //return -1 if user does not exist
            System.out.println("User " + username + " does not exist.");
            return -1;
        }
    }



    public static void main(String[] args) {
        RewardSystem rewardSystem = new RewardSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" 1 to add a user \n 2 to add coins \n 3 to check coins \n 4 to redeem points \n 0 to exit:");
            int choice = scanner.nextInt();
            //buffer line from changing types
            scanner.nextLine();
            //what number the user inputs
            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine().trim();
                    rewardSystem.addUser(username);
                    break;
                case 2:
                    System.out.println("Enter username and coins to add:");
                    System.out.print("Username: ");
                    String user = scanner.nextLine().trim();
                    System.out.print("\n");
                    System.out.print("Coins: ");
                    int coins = scanner.nextInt();
                    //buffer line from changing types
                    scanner.nextLine();
                    rewardSystem.addCoins(user, coins);
                    break;
                case 3:
                    System.out.println("Enter username to check coins:");
                    String checkUser = scanner.nextLine().trim();
                    System.out.println(checkUser + " has " + rewardSystem.checkCoins(checkUser) + " coins.");
                    break;
                case 4:
                    System.out.println("Enter username and coins to redeem:");
                    System.out.print("Username: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("\n");
                    System.out.print("Coins: ");
                    int points = scanner.nextInt();
                    //buffer line from changing types
                    scanner.nextLine();  
                    rewardSystem.redeemPoints(name, points);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    //exit loop and program
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }

    }
}