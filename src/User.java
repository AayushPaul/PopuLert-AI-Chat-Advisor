/**
 * Class representing a user in the reward system.
 */
public class User {
    private String username;
    private int coins;

    /**
     * Constructor for User.
     * @param username The username of the user.
     * @Requires: username is not null.
     * @Ensures: A new User object is created with the given username and 0 coins.
     */
    public User(String username) {
        this.username = username;
        this.coins = 0;
    }

    /**
     * Method to get the username of the user.
     * @return The username of the user.
     * @Ensures: The username of the user is returned.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method to get the number of coins the user has.
     * @return The number of coins the user has.
     * @Ensures: The number of coins the user has is returned.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Method to add coins to the user's account.
     * @param coins The number of coins to be added.
     * @Requires: coins is a positive integer.
     * @Ensures: The specified number of coins are added to the user's account.
     */
    public void addCoins(int coins) {
        this.coins += coins;
    }

    /**
     * Method to redeem points from the user's account.
     * @param points The number of points to be redeemed.
     * @Requires: points is a positive integer.
     * @Ensures: The specified number of points are redeemed from the user's account, or a message is printed if the user does not have enough coins.
     */
    public void redeemPoints(int points) {
        if (this.coins >= points) {
            this.coins -= points;
        } else {
            System.out.println("Not enough coins to redeem points.");
        }
    }
}