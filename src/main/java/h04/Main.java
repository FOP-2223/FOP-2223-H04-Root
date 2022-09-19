package h04;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;


/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // Create a world of size 5x5
        final int worldSize = 5;
        World.setSize(worldSize, worldSize);

        // Sets delay to 200ms
        World.setDelay(200);

        // Show the world
        World.setVisible(true);

        // H1.2 - Fehlermeldungen besser verstehen
        // yourErrorMessage();
        // H2.1 - Zur eigenen Kontrolle
        yourTests();
        // H2.2 - Zur eigenen Kontrolle / Additional Tests
        yourTests2();
        // H2.3 - Zur eigenen Kontrolle / Additional Tests
        yourTests3();
        // H2.4 - Zur eigenen Kontrolle
        yourTests4();

    }

    /**
     * This method cannot compile as mentioned in H1.2
     */
    public static void yourErrorMessage() {
        //WithCoinTypes coinTypes = new WithCoinTypes();
    }


    /**
     * This method tests, whether the RobotWithCoinTypes object is correctly initialized and
     * tests the methods of the interface WithCoinTypes.
     */
    public static void yourTests() {
        // Test the correct initialization of the object
        RobotWithCoinTypes robotWithCoinTypes;
        Robot robot;
        robotWithCoinTypes = new RobotWithCoinTypes(1, 1, Direction.UP, 1, 1, 1);
        robot = new RobotWithCoinTypes(1, 1, Direction.UP, 1, 1, 1);
        System.out.println("x:" + robot.getX() + " , y:" + robot.getY()
            + " , direction:" + robot.getDirection() + ", coins:" + robot.getNumberOfCoins());
        System.out.println("x:" + robotWithCoinTypes.getX() + " , y:" + robotWithCoinTypes.getY()
            + " , direction:" + robotWithCoinTypes.getDirection() + ", coins:" + robotWithCoinTypes.getNumberOfCoins());

        // Test the method putCoin
        robotWithCoinTypes.putCoin();
        System.out.println("Copper coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.COPPER)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());
        robotWithCoinTypes.putCoin();
        System.out.println("Brass coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.BRASS)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());
        robotWithCoinTypes.putCoin();
        System.out.println("Silver coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.SILVER)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());

        // Test the method pickCoin
        robotWithCoinTypes.pickCoin();
        robotWithCoinTypes.pickCoin();
        robotWithCoinTypes.pickCoin();
        System.out.println("Copper coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.COPPER)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());

        // Test the method setNumberOfCoins
        robotWithCoinTypes.setNumberOfCoins(5);
        System.out.println("Copper coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.COPPER)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());

        // Test the method setNumberOfCoinsOfType
        robotWithCoinTypes.setNumberOfCoinsOfType(CoinType.COPPER, 2);
        System.out.println("Copper coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.COPPER)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());
        robotWithCoinTypes.setNumberOfCoinsOfType(CoinType.BRASS, 2);
        System.out.println("Brass coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.BRASS)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());
        robotWithCoinTypes.setNumberOfCoinsOfType(CoinType.SILVER, 2);
        System.out.println("Silver coins: " + robotWithCoinTypes.getNumberOfCoinsOfType(CoinType.SILVER)
            + ", coins:" + robotWithCoinTypes.getNumberOfCoins());

        // Throw an Exception
        // robotWithCoinTypes.setNumberOfCoins(-1);
        // robotWithCoinTypes.setNumberOfCoinsOfType(CoinType.COPPER, -1);
    }

    /**
     * This method tests, whether the robotWithCoinTypesAndRefState1 object is correctly initialized and
     * tests the methods of the interface RobotWithReferenceState.
     */
    public static void yourTests2() {
        // Test the correct initialization of the object
        RobotWithCoinTypesAndRefState1 robotWithCoinTypesAndRefState1;
        Robot robot;
        robotWithCoinTypesAndRefState1 = new RobotWithCoinTypesAndRefState1(1, 1, Direction.UP, 1, 1, 1);
        robot = new RobotWithCoinTypesAndRefState1(1, 1, Direction.UP, 1, 1, 1);
        System.out.println("x:" + robot.getX() + " , y:" + robot.getY()
            + " , direction:" + robot.getDirection() + ", coins:" + robot.getNumberOfCoins());
        System.out.println("x:" + robotWithCoinTypesAndRefState1.getX() + " , y:" + robotWithCoinTypesAndRefState1.getY()
            + " , direction:" + robotWithCoinTypesAndRefState1.getDirection() + ", coins:" + robotWithCoinTypesAndRefState1.getNumberOfCoins());

        // Test all methods besides getDiffDirection
        System.out.println("xDiff: " + robotWithCoinTypesAndRefState1.getDiffX() + ", yDiff: " + robotWithCoinTypesAndRefState1.getDiffY()
            + " , directionDiff: " + robotWithCoinTypesAndRefState1.getDiffDirection() + " , coinsDiff: " + robotWithCoinTypesAndRefState1.getDiffNumberOfCoins());

        robotWithCoinTypesAndRefState1.move();
        robotWithCoinTypesAndRefState1.putCoin();
        System.out.println("xDiff: " + robotWithCoinTypesAndRefState1.getDiffX() + ", yDiff: " + robotWithCoinTypesAndRefState1.getDiffY()
            + " , directionDiff: " + robotWithCoinTypesAndRefState1.getDiffDirection() + " , coinsDiff: " + robotWithCoinTypesAndRefState1.getDiffNumberOfCoins());

        // Exhaustive tests for getDiffDirection
        Direction up = Direction.UP;
        Direction down = Direction.DOWN;
        Direction left = Direction.LEFT;
        Direction right = Direction.RIGHT;

        // Reference: UP
        System.out.println("UP and UP:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("UP and RIGHT:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("UP and DOWN:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("UP and LEFT:" + robotWithCoinTypesAndRefState1.getDiffDirection());

        robotWithCoinTypesAndRefState1.setCurrentStateAsReferenceState();

        // Reference: LEFT
        System.out.println("LEFT and LEFT:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("LEFT and UP:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("LEFT and RIGHT:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("LEFT and DOWN:" + robotWithCoinTypesAndRefState1.getDiffDirection());

        robotWithCoinTypesAndRefState1.setCurrentStateAsReferenceState();

        // Reference: DOWN
        System.out.println("DOWN and DOWN:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("DOWN and LEFT:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("DOWN and UP:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("DOWN and RIGHT:" + robotWithCoinTypesAndRefState1.getDiffDirection());

        robotWithCoinTypesAndRefState1.setCurrentStateAsReferenceState();

        // Reference: RIGHT
        System.out.println("RIGHT and RIGHT:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("RIGHT and DOWN:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("RIGHT and LEFT:" + robotWithCoinTypesAndRefState1.getDiffDirection());
        robotWithCoinTypesAndRefState1.turnLeft();
        System.out.println("RIGHT and UP:" + robotWithCoinTypesAndRefState1.getDiffDirection());

        robotWithCoinTypesAndRefState1.turnLeft();
        robotWithCoinTypesAndRefState1.move();
        System.out.println("xDiff: " + robotWithCoinTypesAndRefState1.getDiffX() + ", yDiff: " + robotWithCoinTypesAndRefState1.getDiffY()
            + " , directionDiff: " + robotWithCoinTypesAndRefState1.getDiffDirection() + " , coinsDiff: " + robotWithCoinTypesAndRefState1.getDiffNumberOfCoins());

    }

    /**
     * This method tests, whether the robotWithCoinTypesAndRefState2 object is correctly initialized and
     * tests the methods of the interface RobotWithReferenceState.
     */
    public static void yourTests3() {
        // Test the correct initialization of the object
        RobotWithCoinTypesAndRefState2 robotWithCoinTypesAndRefState2;
        Robot robot;
        robotWithCoinTypesAndRefState2 = new RobotWithCoinTypesAndRefState2(1, 1, Direction.UP, 1, 1, 1);
        robot = new RobotWithCoinTypesAndRefState1(1, 1, Direction.UP, 1, 1, 1);
        System.out.println("x:" + robot.getX() + " , y:" + robot.getY()
            + " , direction:" + robot.getDirection() + ", coins:" + robot.getNumberOfCoins());
        System.out.println("x:" + robotWithCoinTypesAndRefState2.getX() + " , y:" + robotWithCoinTypesAndRefState2.getY()
            + " , direction:" + robotWithCoinTypesAndRefState2.getDirection() + ", coins:" + robotWithCoinTypesAndRefState2.getNumberOfCoins());

        // Test all methods besides getDiffDirection
        System.out.println("xDiff: " + robotWithCoinTypesAndRefState2.getDiffX() + ", yDiff: " + robotWithCoinTypesAndRefState2.getDiffY()
            + " , directionDiff: " + robotWithCoinTypesAndRefState2.getDiffDirection() + " , coinsDiff: " + robotWithCoinTypesAndRefState2.getDiffNumberOfCoins());

        robotWithCoinTypesAndRefState2.move();
        robotWithCoinTypesAndRefState2.putCoin();
        System.out.println("xDiff: " + robotWithCoinTypesAndRefState2.getDiffX() + ", yDiff: " + robotWithCoinTypesAndRefState2.getDiffY()
            + " , directionDiff: " + robotWithCoinTypesAndRefState2.getDiffDirection() + " , coinsDiff: " + robotWithCoinTypesAndRefState2.getDiffNumberOfCoins());

        // Exhaustive tests for getDiffDirection
        Direction up = Direction.UP;
        Direction down = Direction.DOWN;
        Direction left = Direction.LEFT;
        Direction right = Direction.RIGHT;

        // Reference: UP
        System.out.println("UP and UP:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("UP and RIGHT:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("UP and DOWN:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("UP and LEFT:" + robotWithCoinTypesAndRefState2.getDiffDirection());

        robotWithCoinTypesAndRefState2.setCurrentStateAsReferenceState();

        // Reference: LEFT
        System.out.println("LEFT and LEFT:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("LEFT and UP:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("LEFT and RIGHT:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("LEFT and DOWN:" + robotWithCoinTypesAndRefState2.getDiffDirection());

        robotWithCoinTypesAndRefState2.setCurrentStateAsReferenceState();

        // Reference: DOWN
        System.out.println("DOWN and DOWN:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("DOWN and LEFT:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("DOWN and UP:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("DOWN and RIGHT:" + robotWithCoinTypesAndRefState2.getDiffDirection());

        robotWithCoinTypesAndRefState2.setCurrentStateAsReferenceState();

        // Reference: RIGHT
        System.out.println("RIGHT and RIGHT:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("RIGHT and DOWN:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("RIGHT and LEFT:" + robotWithCoinTypesAndRefState2.getDiffDirection());
        robotWithCoinTypesAndRefState2.turnLeft();
        System.out.println("RIGHT and UP:" + robotWithCoinTypesAndRefState2.getDiffDirection());

        robotWithCoinTypesAndRefState2.turnLeft();
        robotWithCoinTypesAndRefState2.move();
        System.out.println("xDiff: " + robotWithCoinTypesAndRefState2.getDiffX() + ", yDiff: " + robotWithCoinTypesAndRefState2.getDiffY()
            + " , directionDiff: " + robotWithCoinTypesAndRefState2.getDiffDirection() + " , coinsDiff: " + robotWithCoinTypesAndRefState2.getDiffNumberOfCoins());

    }

    /**
     * This method tests the implementation of the class CoinCollection.
     */
    public static void yourTests4(){
        CoinCollection coinCollection = new CoinCollection(1,2,3);

        System.out.println("silver: " + coinCollection.getNumberOfSilverCoins() + " , brass: "
            + coinCollection.getNumberOfBrassCoins() + " , copper: " + coinCollection.getNumberOfCopperCoins());

        // Tests the method insertCoin
        coinCollection.insertCoin(CoinType.SILVER);
        coinCollection.insertCoin(CoinType.BRASS);
        coinCollection.insertCoin(CoinType.COPPER);
        System.out.println("silver: " + coinCollection.getNumberOfSilverCoins() + " , brass: "
            + coinCollection.getNumberOfBrassCoins() + " , copper: " + coinCollection.getNumberOfCopperCoins());

        // Tests the methods setNumberOfCoinsOfType and removeCoin
        coinCollection.setNumberOfCoinsOfType(CoinType.SILVER, -1);
        coinCollection.removeCoin(CoinType.SILVER);
        coinCollection.removeCoin(CoinType.BRASS);
        System.out.println("silver: " + coinCollection.getNumberOfSilverCoins() + " , brass: "
            + coinCollection.getNumberOfBrassCoins() + " , copper: " + coinCollection.getNumberOfCopperCoins());

        // Tests the method getNumberOfCoinsOfType
        System.out.println("silver: " + coinCollection.getNumberOfCoinsOfType(CoinType.SILVER) + " , brass: "
            + coinCollection.getNumberOfCoinsOfType(CoinType.BRASS)
            + " , copper: " + coinCollection.getNumberOfCoinsOfType(CoinType.COPPER));
    }
}
