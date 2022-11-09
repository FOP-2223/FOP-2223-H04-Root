package h04;

import fopbot.Direction;
import fopbot.Robot;

/**
 * Represents a robot with three coin types (silver, brass and copper).
 */
public class RobotWithCoinTypes extends Robot implements WithCoinTypes {
    /**
     * The amount of silver coins the robot has
     */
    private int numberOfSilverCoins;
    /**
     * The amount of brass coins the robot has
     */
    private int numberOfBrassCoins;
    /**
     * The amount of copper coins the robot has
     */
    private int numberOfCopperCoins;

    /**
     * Initializes a new robot with three coin types.
     *
     * @param x The value of the x-coordinate of the robot.
     * @param y The value of the y-coordinate of the robot.
     * @param direction The value of the direction of the robot.
     * @param numberOfSilverCoins The amount of the silver coins of the robot.
     * @param numberOfBrassCoins The amount of the brass coins of the robot.
     * @param numberOfCopperCoins The amount of the copper coins of the robot.
     */
    public RobotWithCoinTypes(int x, int y, Direction direction, int numberOfSilverCoins,
                              int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins);
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.numberOfBrassCoins = numberOfBrassCoins;
        this.numberOfCopperCoins = numberOfCopperCoins;
    }

    @Override
    public int getNumberOfCoinsOfType(CoinType type) {
        return switch (type) {
            case SILVER -> numberOfSilverCoins;
            case BRASS -> numberOfBrassCoins;
            case COPPER -> numberOfCopperCoins;
        };
    }

    @Override
    public void setNumberOfCoinsOfType(CoinType type, int number) {
        if (number < 0) {
            // leads to exception as number of coins < 0 is invalid
            super.setNumberOfCoins(number);
        }
        switch (type) {
            case SILVER -> numberOfSilverCoins = number;
            case BRASS -> numberOfBrassCoins = number;
            case COPPER -> numberOfCopperCoins = number;
        }
        super.setNumberOfCoins(numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins);
    }

    @Override
    public void setNumberOfCoins(int number) {
        if (number < 0) {
            // leads to exception as number of coins < 0 is invalid
            super.setNumberOfCoins(number);
        }
        else {
            numberOfCopperCoins = number;
            super.setNumberOfCoins(numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins);
        }
    }

    @Override
    public void pickCoin() {
        super.pickCoin();
        numberOfCopperCoins++;
    }

    @Override
    public void putCoin() {
        if (numberOfSilverCoins > 0) {
            numberOfSilverCoins--;
        }
        else if (numberOfBrassCoins > 0) {
            numberOfBrassCoins--;
        }
        else if (numberOfCopperCoins > 0) {
            numberOfCopperCoins--;
        }
        // leads to exception if getNumberOfCoins() == 0
        super.putCoin();
    }
}
