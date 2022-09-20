package h04;

import fopbot.Direction;

/**
 * Represents a robot with a reference state.
 */
public class RobotWithCoinTypesAndRefStateTwo extends RobotWithCoinTypes implements RobotWithReferenceState{

    /**
     * The reference robot
     */
    private ReferenceRobot referenceRobot;

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
    public RobotWithCoinTypesAndRefStateTwo(int x, int y, Direction direction, int numberOfSilverCoins,
                                            int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins);
        referenceRobot = new ReferenceRobot(x, y, direction,
            numberOfCopperCoins + numberOfBrassCoins + numberOfSilverCoins);
    }

    @Override
    public void setCurrentStateAsReferenceState() {
        referenceRobot.setRefX(this.getX());
        referenceRobot.setRefY(this.getY());
        referenceRobot.setRefDirection(this.getDirection());
        referenceRobot.setRefNumberOfCoins(this.getNumberOfCoins());
    }

    @Override
    public int getDiffX() {
        return this.getX() - referenceRobot.getRefX();
    }

    @Override
    public int getDiffY() {
        return this.getY() - referenceRobot.getRefY();
    }

    @Override
    public Direction getDiffDirection() {
        Direction currDirection = this.getDirection();
        Direction refDirection = referenceRobot.getRefDirection();

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
        return this.getNumberOfCoins() - referenceRobot.getRefNumberOfCoins();
    }
}
