package h04;

/**
 * Represents a coin collector with three coin types (silver, brass and copper).
 */
public class CoinCollection implements WithCoinTypes {
    /**
     * The amount of silver coins the coin collection contains
     */
    private int numberOfSilverCoins;
    /**
     * The amount of brass coins the coin collection contains
     */
    private int numberOfBrassCoins;
    /**
     * The amount of copper coins the coin collection contains
     */
    private int numberOfCopperCoins;

    /**
     * Initializes a new Coin Collector with three coin types.
     *
     * @param numberOfSilverCoins the amount of the silver coins
     * @param numberOfBrassCoins the amount of the brass coins
     * @param numberOfCopperCoins the amount of the copper coins
     */
    public CoinCollection(int numberOfSilverCoins, int numberOfBrassCoins, int numberOfCopperCoins) {
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.numberOfBrassCoins = numberOfBrassCoins;
        this.numberOfCopperCoins = numberOfCopperCoins;
    }

    @Override
    public void setNumberOfCoinsOfType(CoinType type, int number) {
        number = Math.max(0, number);
        switch (type) {
            case BRASS -> numberOfBrassCoins = number;
            case SILVER -> numberOfSilverCoins = number;
            case COPPER -> numberOfCopperCoins = number;
        }
    }

    @Override
    public int getNumberOfCoinsOfType(CoinType type) {
        return switch (type) {
            case SILVER -> numberOfSilverCoins;
            case BRASS -> numberOfBrassCoins;
            case COPPER -> numberOfCopperCoins;
        };
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

    /**
     * This method adds a coin of the specified coin type.
     *
     * @param type the specified coin type
     */
    public void insertCoin(CoinType type) {
        setNumberOfCoinsOfType(type, getNumberOfCoinsOfType(type) + 1);
    }

    /**
     * This method removes a coin of the specified coin type.
     *
     * @param type the specified coin type
     */
    public void removeCoin(CoinType type) {
        setNumberOfCoinsOfType(type, getNumberOfCoinsOfType(type) - 1);
    }
}
