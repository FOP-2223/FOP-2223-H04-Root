package h04;

/**
 * Represents possible usages of different coin types.
 */
public interface WithCoinTypes {

    /**
     * This method returns the current amount of coins of coinType.
     *
     * @param coinType the coin type which amount should be returned
     * @return the amount of the specified coin type
     */
    int getNumberOfCoinsOfType(CoinType coinType);

    /**
     * This method sets the amount of coins of coinType to the value of number.
     *
     * @param coinType the coin type which amount should be changed
     * @param number the new value for the specified coin type
     */
    void setNumberOfCoinsOfType(CoinType coinType, int number);
}
