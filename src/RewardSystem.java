import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to add a user \n 2 to add coins \n 3 to check coins \n 4 to redeem points \n 0 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    rewardSystem.addUser(username);
                    break;
                case 2:
                    System.out.println("Enter username and coins to add:");
                    System.out.print("username: ");
                    String user = scanner.nextLine();
                    System.out.print("\n");
                    System.out.print("coins: ");
                    int coins = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    rewardSystem.addCoins(user, coins);
                    break;
                case 3:
                    System.out.println("Enter username to check coins:");
                    String checkUser = scanner.nextLine();
                    System.out.println(checkUser + " has " + rewardSystem.checkCoins(checkUser) + " coins.");
                    break;
                case 4:
                    System.out.println("Enter username and coins to add:");
                    System.out.print("username: ");
                    String name = scanner.nextLine();
                    System.out.print("\n");
                    System.out.print("coins: ");
                    int points = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    rewardSystem.redeemPoints(name, points);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }

    }
}