package h04;

import fopbot.Direction;

/**
 * Represents a robot with a reference state.
 */
public class RobotWithCoinTypesAndRefState1 extends RobotWithCoinTypes implements RobotWithReferenceState{

    /**
     * The x-coordinate the reference robot has
     */
    private int refX;
    /**
     * The y-coordinate the reference robot has
     */
    private int refY;
    /**
     * The direction the reference robot has
     */
    private Direction refDirection;
    /**
     * The amount of coins the reference robot has
     */
    private int refNumberOfCoins;

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
    public RobotWithCoinTypesAndRefState1(int x, int y, Direction direction, int numberOfSilverCoins,
                                          int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins);
        refX = x;
        refY = y;
        refDirection = direction;
        refNumberOfCoins = numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins;
    }


    @Override
    public void setCurrentStateAsReferenceState() {
        refX = this.getX();
        refY = this.getY();
        refDirection = this.getDirection();
        refNumberOfCoins = this.getNumberOfCoins();
    }

    @Override
    public int getDiffX() {
        return this.getX() - refX;
    }

    @Override
    public int getDiffY() {
        return this.getY() - refY;
    }

    @Override
    public Direction getDiffDirection() {
        Direction currDirection = this.getDirection();

        if (refDirection.equals(currDirection))
            return Direction.UP;
        // UP and LEFT, LEFT and DOWN, DOWN and RIGHT, RIGHT and UP
        // 0 and 1, 1 and 2, 2 and 3, 3 and 0
        else if (refDirection.ordinal() + 3 == currDirection.ordinal()
            || refDirection.ordinal() - 1 == currDirection.ordinal())
            return Direction.LEFT;
        // UP and DOWN, DOWN and UP, RIGHT and LEFT, LEFT and RIGHT
        // 0 and 2, 2 and 0, 1 and 3, 3 and 1
        else if (currDirection.ordinal() - 2 == refDirection.ordinal()
            || currDirection.ordinal() + 2 == refDirection.ordinal())
            return Direction.DOWN;
        else
            return Direction.RIGHT;
    }

    @Override
    public int getDiffNumberOfCoins() {
        return this.getNumberOfCoins() - refNumberOfCoins;
    }

}
