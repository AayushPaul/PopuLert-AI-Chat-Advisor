public class User {
    private String username;
    private int coins;

    public User(String username) {
        this.username = username;
        this.coins = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void redeemPoints(int points) {
        if (this.coins >= points) {
            this.coins -= points;
        } else {
            System.out.println("Not enough coins to redeem points.");
        }
    }
}