package h04;

import fopbot.Direction;

/**
 * Represents a robot with a reference state and multiple coin types. Uses a roboter as reference state internally.
 */
public class RobotWithCoinTypesAndRefStateTwo extends RobotWithCoinTypes implements RobotWithReferenceState {
    /**
     * The reference robot.
     */
    private ReferenceRobot refRobot;

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
    public RobotWithCoinTypesAndRefStateTwo(int x, int y, Direction direction, int numberOfSilverCoins,
                                             int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins);
        int totalNumberOfCoins = numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins;
        refRobot = new ReferenceRobot(x, y, direction, totalNumberOfCoins);
    }

    @Override
    public void setCurrentStateAsReferenceState() {
        refRobot.setRefX(getX());
        refRobot.setRefY(getY());
        refRobot.setRefDirection(getDirection());
        refRobot.setRefNumberOfCoins(getNumberOfCoins());
    }

    @Override
    public int getDiffX() {
        return getX() - refRobot.getRefX();
    }

    @Override
    public int getDiffY() {
        return getY() - refRobot.getRefY();
    }

    @Override
    public Direction getDiffDirection() {
        int relativeDirection = getDirection().ordinal() - refRobot.getRefDirection().ordinal();
        return Direction.values()[Math.floorMod(relativeDirection, Direction.values().length)];
    }

    @Override
    public int getDiffNumberOfCoins() {
        return getNumberOfCoins() - refRobot.getRefNumberOfCoins();
    }
}
