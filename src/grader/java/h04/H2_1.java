package h04;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.reflect.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;


@TestForSubmission("h04")
@DisplayName("H2_1")
public class H2_1 {
    public final static double minSim = 0.8d;

    public final static ClassTester<Object> RobotWithCoinTypesCT = new ClassTester("h04",
        "RobotWithCoinTypes", minSim, Modifier.PUBLIC,
        Robot.class,
        new ArrayList<>(List.of(new IdentifierMatcher("WithCoinTypes", "h04", minSim))));
    public final static ClassTester<?> RobotCT = new ClassTester<>("fopbot",
        "Robot", minSim, Modifier.PUBLIC);

    final String class_name = "RobotWithCoinTypes";

    public static void setupWorld() {
        World.reset();
        World.setSize(5, 5);
        World.setDelay(0);
        World.setVisible(false);
    }

    @Test
    @DisplayName("1 | Existenz Klasse " + class_name)
    public void test01() {
        RobotWithCoinTypesCT.setSuperClass((Class<Object>) RobotCT.assureClassResolved().getTheClass());
        RobotWithCoinTypesCT.setImplementsInterfaces(
            new ArrayList<>(List.of(new IdentifierMatcher("WithCoinTypes", "h04", minSim))));
        RobotWithCoinTypesCT.verify(1.0d);
    }

    @Test
    @DisplayName("2 | Konstruktor")
    public void test02() {
        ParameterMatcher [] parameterMatcher = new ParameterMatcher[6];
        parameterMatcher[0] = new ParameterMatcher("x", 0.8, int.class);
        parameterMatcher[1] = new ParameterMatcher("y", 0.8, int.class);
        parameterMatcher[2] = new ParameterMatcher("direction", 0.8, Direction.class);
        parameterMatcher[3] = new ParameterMatcher("numberOfSilverCoins", 0.8, int.class);
        parameterMatcher[4] = new ParameterMatcher("numberOfBrassCoins", 0.8, int.class);
        parameterMatcher[5] = new ParameterMatcher("numberOfCopperCoins", 0.8, int.class);

        RobotWithCoinTypesCT.assureClassResolved();
        var constructor = (Constructor<Object>) RobotWithCoinTypesCT.resolveConstructor(parameterMatcher);
        ((ClassTester<Object>) RobotWithCoinTypesCT).assertConstructorValid(constructor, Modifier.PUBLIC,
            parameterMatcher);

        Field numberOfSilverCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        setupWorld();

        // Valid Value
        ((ClassTester<Object>) RobotWithCoinTypesCT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance(1, 1, Direction.UP, 1, 2, 3)));

        RobotWithCoinTypesCT.assertFieldEquals(numberOfSilverCoinsField, 1);
        RobotWithCoinTypesCT.assertFieldEquals(numberOfBrassCoinsField, 2);
        RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, 3);

        // Bigger Value
        ((ClassTester<Object>) RobotWithCoinTypesCT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance( 1, 1, Direction.UP, 10, 20, 30)));
        RobotWithCoinTypesCT.assertFieldEquals(numberOfSilverCoinsField, 10);
        RobotWithCoinTypesCT.assertFieldEquals(numberOfBrassCoinsField, 20);
        RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, 30);
    }

    @Test
    @DisplayName("3 | getNumberOfCoinsOfType()")
    public void test03() {
        RobotWithCoinTypesCT.resolve();

        Field numberOfSilverCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester mt = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            int.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class)))).verify();
        mt.resolveMethod();

        for (int i = 0; i <= 20; i++) {
            RobotWithCoinTypesCT.setField(numberOfSilverCoinsField, i);
            mt.assertReturnValueEquals(
                i,
                CoinType.SILVER);

            RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, i);
            mt.assertReturnValueEquals(
                i,
                CoinType.BRASS);

            RobotWithCoinTypesCT.setField(numberOfCopperCoinsField, i);
            mt.assertReturnValueEquals(
                i,
                CoinType.COPPER);
        }
    }

    @Test
    @DisplayName("4 | setNumberOfCoinsOfType()")
    public void test04() {
        RobotWithCoinTypesCT.resolveClass();
        RobotWithCoinTypesCT.setClassInstance(mock(RobotWithCoinTypesCT.getTheClass(), RETURNS_DEEP_STUBS));

        Field numberOfSilverCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = RobotWithCoinTypesCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester mt = new MethodTester(
            RobotWithCoinTypesCT, "setNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            void.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class),
            new ParameterMatcher("number", 0.8, int.class)
            ))).verify();
        mt.resolveMethod();

        MethodTester mt2 = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoins", 1.0, Modifier.PUBLIC,
            int.class, null, true).verify();
        mt2.resolveMethod();

        setupWorld();

        // Test Values
        for (int i = 0; i <= 20; i++) {
            mt.invoke(CoinType.SILVER, i);
            mt2.assertReturnValueEquals(i);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfSilverCoinsField, i);

            mt.invoke(CoinType.BRASS, i);
            mt2.assertReturnValueEquals(2*i);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfBrassCoinsField, i);

            mt.invoke(CoinType.COPPER, i);
            mt2.assertReturnValueEquals(3*i);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, i);
        }

        RobotWithCoinTypes testRobot = new RobotWithCoinTypes(1,1,Direction.UP,1,2,3);

        // Throws Exception
        // metodTester.getTheMethd().invoke(mt.getClassTester().getClassInstance())
        assertThrows(RuntimeException.class,
            () -> testRobot.setNumberOfCoinsOfType(CoinType.COPPER, -1));

        // Test Robot Method Call
        for (int i = 0; i <= 20; i++) {
            testRobot.setNumberOfCoinsOfType(CoinType.SILVER, i);
            testRobot.setNumberOfCoinsOfType(CoinType.BRASS, i);
            testRobot.setNumberOfCoinsOfType(CoinType.COPPER, i);
            mt.invoke(CoinType.SILVER, i);
            mt.invoke(CoinType.BRASS, i);
            mt.invoke(CoinType.COPPER, i);
            //mt2.assertReturnValueEquals(3*i);

            testRobot.setNumberOfCoinsOfType(CoinType.SILVER, i+1);
            //assertEquals(testRobot.getNumberOfCoins(), 3*i+1);

            testRobot.setNumberOfCoinsOfType(CoinType.BRASS, i+1);
            //assertEquals(testRobot.getNumberOfCoins(), 3*i+2);

            testRobot.setNumberOfCoinsOfType(CoinType.COPPER, i+1);
            //assertEquals(testRobot.getNumberOfCoins(), 3*i+3);
        }
    }

    @Test
    @DisplayName("5 | Attribute numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins")
    public void test05() {
        RobotWithCoinTypesCT.resolve();
        for (var fieldMatcher : new AttributeMatcher[]{
            new AttributeMatcher("numberOfSilverCoins", 0.8, Modifier.PRIVATE, int.class),
            new AttributeMatcher("numberOfBrassCoins", 0.8, Modifier.PRIVATE, int.class),
            new AttributeMatcher("numberOfCopperCoins", 0.8, Modifier.PRIVATE, int.class)
        }) {
            RobotWithCoinTypesCT.resolveAttribute(fieldMatcher);
        }
    }

}

