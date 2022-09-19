package h04;

import fopbot.Direction;
import fopbot.KarelWorld;
import fopbot.Robot;
import fopbot.World;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.reflect.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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
            -> constructor.newInstance(0, 0, Direction.UP, 1, 2, 3)));

        RobotWithCoinTypesCT.assertFieldEquals(numberOfSilverCoinsField, 1);
        RobotWithCoinTypesCT.assertFieldEquals(numberOfBrassCoinsField, 2);
        RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, 3);

        // Bigger Value
        ((ClassTester<Object>) RobotWithCoinTypesCT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance( 0, 0, Direction.UP, 10, 20, 30)));
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

        MethodTester setNumberOfCoinTypesMT = new MethodTester(
            RobotWithCoinTypesCT, "setNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            void.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class),
            new ParameterMatcher("number", 0.8, int.class)
            ))).verify();
        setNumberOfCoinTypesMT.resolveMethod();

        MethodTester getNumberOfCoinsMT = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoins", 1.0, Modifier.PUBLIC,
            int.class, null, true).verify();
        getNumberOfCoinsMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesCT.getTheClass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesCT.setField(world, World.getGlobalWorld());
        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesCT.getClassInstance());


        // Test Values and Robot Method Call
        for (int i = 0; i <= 20; i++) {
            RobotWithCoinTypesCT.setField(numberOfSilverCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfCopperCoinsField, 0);
            setNumberOfCoinTypesMT.invoke(CoinType.SILVER, i);
            getNumberOfCoinsMT.assertReturnValueEquals(i);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfSilverCoinsField, i);

            setNumberOfCoinTypesMT.invoke(CoinType.BRASS, i);
            getNumberOfCoinsMT.assertReturnValueEquals(2*i);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfBrassCoinsField, i);

            setNumberOfCoinTypesMT.invoke(CoinType.COPPER, i);
            getNumberOfCoinsMT.assertReturnValueEquals(3*i);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, i);
        }

        // Throws Exception
        try{
            setNumberOfCoinTypesMT.getTheMethod().invoke(RobotWithCoinTypesCT.getClassInstance(),
                    CoinType.BRASS, -1);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            assertEquals(RuntimeException.class, e.getCause().getClass());
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

    @Test
    @DisplayName("6 | setNumberOfCoins()")
    public void test06() {
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

        MethodTester setNumberOfCoinsMT = new MethodTester(
            RobotWithCoinTypesCT, "setNumberOfCoins", 0.8, Modifier.PUBLIC,
            void.class, new ArrayList<>(List.of(new ParameterMatcher("number", 0.8, int.class)
        ))).verify();
        setNumberOfCoinsMT.resolveMethod();

        MethodTester getNumberOfCoinsOfTypeMT = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            int.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class)))).verify();

        getNumberOfCoinsOfTypeMT.resolveMethod();

        MethodTester getNumberOfCoinsMT = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoins", 1.0, Modifier.PUBLIC,
            int.class, null, true).verify();
        getNumberOfCoinsMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesCT.getTheClass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesCT.setField(world, World.getGlobalWorld());
        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesCT.getClassInstance());


        // Test Values and Robot Method Call
        for (int i = 0; i <= 20; i++) {
            RobotWithCoinTypesCT.setField(numberOfCopperCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfSilverCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, 0);

            setNumberOfCoinsMT.invoke(i);
            getNumberOfCoinsMT.assertReturnValueEquals(i);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(i, CoinType.COPPER);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, i);
        }

        // Throws Exception
        try {
            setNumberOfCoinsMT.getTheMethod().invoke(RobotWithCoinTypesCT.getClassInstance(), -1);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            assertEquals(RuntimeException.class, e.getCause().getClass());
        }

    }

    @Test
    @DisplayName("7 | pickCoin()")
    public void test07() {
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

        MethodTester pickCoinMT = new MethodTester(
            RobotWithCoinTypesCT, "pickCoin", 0.8, Modifier.PUBLIC,
            void.class).verify();
        pickCoinMT.resolveMethod();

        MethodTester getNumberOfCoinsOfTypeMT = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            int.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class)))).verify();
        getNumberOfCoinsOfTypeMT.resolveMethod();

        MethodTester getNumberOfCoinsMT = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoins", 1.0, Modifier.PUBLIC,
            int.class, null, true).verify();
        getNumberOfCoinsMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesCT.getTheClass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesCT.setField(world, World.getGlobalWorld());
        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesCT.getClassInstance());
        World.getGlobalWorld().putCoins(0,0,21);

        // Test Values and Robot Method Call
        for (int i = 0; i <= 20; i++) {
            RobotWithCoinTypesCT.setField(numberOfCopperCoinsField, i);
            RobotWithCoinTypesCT.setField(numberOfSilverCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, 0);

            pickCoinMT.invoke();
            getNumberOfCoinsMT.assertReturnValueEquals(i + 1);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(i + 1, CoinType.COPPER);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, i + 1);
        }
    }

    @Test
    @DisplayName("8 | putCoin()")
    public void test08() {
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

        MethodTester putCoinMT = new MethodTester(
            RobotWithCoinTypesCT, "putCoin", 0.8, Modifier.PUBLIC,
            void.class).verify();
        putCoinMT.resolveMethod();

        MethodTester getNumberOfCoinsOfTypeMT = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            int.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class)))).verify();
        getNumberOfCoinsOfTypeMT.resolveMethod();

        MethodTester getNumberOfCoinsMT = new MethodTester(
            RobotWithCoinTypesCT, "getNumberOfCoins", 1.0, Modifier.PUBLIC,
            int.class, null, true).verify();
        getNumberOfCoinsMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesCT.getTheClass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesCT.setField(world, World.getGlobalWorld());
        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesCT.getClassInstance());
        ((Robot) RobotWithCoinTypesCT.getClassInstance()).setNumberOfCoins(30);

        // Test Values and Robot Method Call
        for (int i = 30; i >= 1; i = i-3) {
            // Test if it puts copper, when there is copper available
            RobotWithCoinTypesCT.setField(numberOfCopperCoinsField, i);
            RobotWithCoinTypesCT.setField(numberOfSilverCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, 0);

            putCoinMT.invoke();
            getNumberOfCoinsMT.assertReturnValueEquals(i - 1);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(i - 1, CoinType.COPPER);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(0, CoinType.BRASS);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(0, CoinType.SILVER);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfCopperCoinsField, i - 1);

            // Test if it puts brass, when there is no copper, but brass available
            RobotWithCoinTypesCT.setField(numberOfCopperCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, i);

            putCoinMT.invoke();
            getNumberOfCoinsMT.assertReturnValueEquals(i - 2);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(0, CoinType.COPPER);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(i - 1, CoinType.BRASS);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(0, CoinType.SILVER);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfBrassCoinsField, i - 1);

            // Test if it puts silver, when there is no copper and brass, but silver available
            RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, 0);
            RobotWithCoinTypesCT.setField(numberOfSilverCoinsField, i);

            putCoinMT.invoke();
            getNumberOfCoinsMT.assertReturnValueEquals(i - 3);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(0, CoinType.COPPER);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(0, CoinType.BRASS);
            getNumberOfCoinsOfTypeMT.assertReturnValueEquals(i - 1, CoinType.SILVER);
            RobotWithCoinTypesCT.assertFieldEquals(numberOfSilverCoinsField, i - 1);
        }

        // Throw Exception
        RobotWithCoinTypesCT.setField(numberOfCopperCoinsField, 0);
        RobotWithCoinTypesCT.setField(numberOfSilverCoinsField, 0);
        RobotWithCoinTypesCT.setField(numberOfBrassCoinsField, 0);

        try {
            putCoinMT.getTheMethod().invoke(RobotWithCoinTypesCT.getClassInstance());
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            assertEquals(RuntimeException.class, e.getCause().getClass());
        }
    }
}

