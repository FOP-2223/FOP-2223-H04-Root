package h04;

import fopbot.Direction;

/**
 * Represents a robot with a reference state and multiple coin types.
 */
public class RobotWithCoinTypesAndRefStateOne extends RobotWithCoinTypes implements RobotWithReferenceState {
    /**
     * The referenced x-coordinate of the robot.
     */
    private int refX;
    /**
     * The referenced y-coordinate of the robot.
     */
    private int refY;
    /**
     * The referenced direction of the robot.
     */
    private Direction refDirection;
    /**
     * The referenced amount of coins of the robot.
     */
    private int refNumberOfCoins;

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
    public RobotWithCoinTypesAndRefStateOne(int x, int y, Direction direction,
                                            int numberOfSilverCoins, int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins);
        setCurrentStateAsReferenceState();
    }

    @Override
    public void setCurrentStateAsReferenceState() {
        refX = getX();
        refY = getY();
        refDirection = getDirection();
        refNumberOfCoins = getNumberOfCoins();
    }

    @Override
    public int getDiffX() {
        return getX() - refX;
    }

    @Override
    public int getDiffY() {
        return getY() - refY;
    }

    @Override
    public Direction getDiffDirection() {
        int relativeDirection = getDirection().ordinal() - refDirection.ordinal();
        return Direction.values()[Math.floorMod(relativeDirection, Direction.values().length)];
    }

    @Override
    public int getDiffNumberOfCoins() {
        return getNumberOfCoins() - refNumberOfCoins;
    }
}
