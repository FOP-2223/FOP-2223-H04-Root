package h04;

/**
 * Represents a coin collector with three coin types (silver, brass and copper).
 */
public class CoinCollection implements WithCoinTypes{

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
     * Initializes a new Coin Collector with three coin types.
     *
     * @param numberOfSilverCoins the amount of the silver coins
     * @param numberOfBrassCoins the amount of the brass coins
     * @param numberOfCopperCoins the amount of the copper coins
     */
    public CoinCollection(int numberOfSilverCoins, int numberOfBrassCoins, int numberOfCopperCoins){
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.numberOfBrassCoins = numberOfBrassCoins;
        this.numberOfCopperCoins = numberOfCopperCoins;
    }

    /**
     * This method returns the current amount of silver coins.
     *
     * @return amount of silver coins
     */
    public int getNumberOfSilverCoins() {
        return numberOfSilverCoins;
    }

    /**
     * This method returns the current amount of brass coins.
     *
     * @return amount of brass coins
     */
    public int getNumberOfBrassCoins() {
        return numberOfBrassCoins;
    }

    /**
     * This method returns the current amount of copper coins.
     *
     * @return amount of copper coins
     */
    public int getNumberOfCopperCoins() {
        return numberOfCopperCoins;
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
        number = number > 0 ? number : 0;
        // Set the value of the attribute representing the amount of coins
        // for the coinType to number
        if (coinType.equals(CoinType.SILVER))
            numberOfSilverCoins = number;
        else if (coinType.equals(CoinType.BRASS))
            numberOfBrassCoins = number;
        else
            numberOfCopperCoins = number;
    }

    /**
     * This method adds a coin of the specified coin type.
     *
     * @param coinType the specified coin type
     */
    public void insertCoin(CoinType coinType){
        if (coinType.equals(CoinType.SILVER))
            numberOfSilverCoins++;
        else if (coinType.equals(CoinType.BRASS))
            numberOfBrassCoins++;
        else
            numberOfCopperCoins++;
    }

    /**
     * This method removes a coin of the specified coin type.
     *
     * @param coinType the specified coin type
     */
    public void removeCoin(CoinType coinType){
        if (coinType.equals(CoinType.SILVER))
            numberOfSilverCoins = numberOfSilverCoins > 0 ? numberOfSilverCoins - 1 : numberOfSilverCoins;
        else if (coinType.equals(CoinType.BRASS))
            numberOfBrassCoins = numberOfBrassCoins > 0 ? numberOfBrassCoins - 1 : numberOfBrassCoins;
        else
            numberOfCopperCoins = numberOfCopperCoins > 0 ? numberOfCopperCoins - 1 : numberOfCopperCoins;
    }
}
