package h04;

import fopbot.Direction;
import fopbot.Robot;

/**
 * Represents a robot with three coin types (silver, brass and copper).
 */
public class RobotWithCoinTypes extends Robot implements WithCoinTypes{

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
     * @param x the value of the x-coordinate of the robot
     * @param y the value of the y-coordinate of the robot
     * @param direction the value of the direction of the robot
     * @param numberOfSilverCoins the amount of the silver coins of the robot
     * @param numberOfBrassCoins the amount of the brass coins of the robot
     * @param numberOfCopperCoins the amount of the copper coins of the robot
     */
    public RobotWithCoinTypes(int x, int y, Direction direction, int numberOfSilverCoins,
                                          int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins);
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.numberOfBrassCoins = numberOfBrassCoins;
        this.numberOfCopperCoins = numberOfCopperCoins;
    }

    @Override
    public int getNumberOfCoinsOfType(CoinType coinType) {
        if (coinType.equals(CoinType.SILVER))
            return numberOfSilverCoins;
        else if (coinType.equals(CoinType.BRASS))
            return numberOfBrassCoins;
        else
            return numberOfCopperCoins;
    }

    @Override
    public void setNumberOfCoinsOfType(CoinType coinType, int number) {
        // If the value of number is negative, call the method from Robot
        if (number < 0)
            super.setNumberOfCoins(number);

        // Set the value of the attribute representing the amount of coins
        // for the coinType to number
        if (coinType.equals(CoinType.SILVER))
            numberOfSilverCoins = number;
        else if (coinType.equals(CoinType.BRASS))
            numberOfBrassCoins = number;
        else
            numberOfCopperCoins = number;

        // Set numberOfCoins in Robot to the new amount after updating the values
        // of the attribute
        int currentCoins = numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins;
        super.setNumberOfCoins(currentCoins);
    }

    @Override
    public void setNumberOfCoins(int number) {
        // if the value of number is negative, call the corresponding method of Robot
        if (number < 0)
           super.setNumberOfCoins(number);
        // else add copper coins and update numberOfCoins
        else{
                numberOfCopperCoins = number;
                int currentCoins = numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins;
                super.setNumberOfCoins(currentCoins);
            }
    }

    @Override
    public void pickCoin(){
        // pick up coin is always a copper coin
        numberOfCopperCoins++;
        super.pickCoin();
    }

    @Override
    public void putCoin(){
        // put a coin: copper, if available
        // brass, if copper not available
        // silver, if copper and brass not available
        if (numberOfCopperCoins > 0)
            numberOfCopperCoins--;
        else if (numberOfBrassCoins > 0)
            numberOfBrassCoins--;
        else if (numberOfSilverCoins > 0)
            numberOfSilverCoins--;
        // will automatically throw an exception, if there are not enough coins
        super.putCoin();
    }
}
