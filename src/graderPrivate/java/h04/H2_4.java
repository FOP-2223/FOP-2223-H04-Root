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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestForSubmission("h04")
@DisplayName("H2_4")
public class H2_4 {

    public final static double minSim = 0.8d;

    public final static ClassTester<Object> CoinCollectionCT = new ClassTester("h04",
        "CoinCollection", minSim, Modifier.PUBLIC, null,
        new ArrayList<>(List.of(new IdentifierMatcher("WithCoinTypes", "h04", minSim))));

    final String class_name = "CoinCollection";

    public static void setupWorld() {
        World.reset();
        World.setSize(15, 15);
        World.setDelay(0);
        World.setVisible(false);
    }

    @Test
    @DisplayName("1 | Existenz Klasse " + class_name)
    public void test01() {
        CoinCollectionCT.setImplementsInterfaces(
            new ArrayList<>(List.of(new IdentifierMatcher("WithCoinTypes", "h04", minSim))));
        CoinCollectionCT.verify(1.0d);
    }

    @Test
    @DisplayName("2 | Konstruktor")
    public void test02() {
        ParameterMatcher[] parameterMatcher = new ParameterMatcher[3];
        parameterMatcher[0] = new ParameterMatcher("numberOfSilverCoins", 0.8, int.class);
        parameterMatcher[1] = new ParameterMatcher("numberOfBrassCoins", 0.8, int.class);
        parameterMatcher[2] = new ParameterMatcher("numberOfCopperCoins", 0.8, int.class);

        CoinCollectionCT.assureClassResolved();
        var constructor = (Constructor<Object>) CoinCollectionCT.resolveConstructor(parameterMatcher);
        ((ClassTester<Object>) CoinCollectionCT).assertConstructorValid(constructor, Modifier.PUBLIC,
            parameterMatcher);

        Field numberOfSilverCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, ReferenceRobot.class));

        setupWorld();

        // Valid Value
        ((ClassTester<Object>) CoinCollectionCT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance(1, 2, 3)));

        CoinCollectionCT.assertFieldEquals(numberOfSilverCoinsField, 1);
        CoinCollectionCT.assertFieldEquals(numberOfBrassCoinsField, 2);
        CoinCollectionCT.assertFieldEquals(numberOfCopperCoinsField, 3);

        // Bigger Value
        ((ClassTester<Object>) CoinCollectionCT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance( 10, 20, 30)));

        CoinCollectionCT.assertFieldEquals(numberOfSilverCoinsField, 10);
        CoinCollectionCT.assertFieldEquals(numberOfBrassCoinsField, 20);
        CoinCollectionCT.assertFieldEquals(numberOfCopperCoinsField, 30);
    }

    @Test
    @DisplayName("3 | getNumberOfSilverCoins()")
    public void test03() {
        CoinCollectionCT.resolve();

        Field numberOfSilverCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester getNumberOfSilverCoinsMT = new MethodTester(
            CoinCollectionCT, "getNumberOfSilverCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getNumberOfSilverCoinsMT.resolveMethod();

        for (int i = 0; i < 10; i++){
            CoinCollectionCT.setField(numberOfSilverCoinsField, i);
            getNumberOfSilverCoinsMT.assertReturnValueEquals(i);
        }
    }

    @Test
    @DisplayName("4 | Attribute numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins")
    public void test04() {

    }

    @Test
    @DisplayName("5 | getNumberOfBrassCoins()")
    public void test05() {
        CoinCollectionCT.resolve();

        Field numberOfBrassCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester getNumberOfBrassCoinsMT = new MethodTester(
            CoinCollectionCT, "getNumberOfBrassCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getNumberOfBrassCoinsMT.resolveMethod();

        for (int i = 0; i < 10; i++){
            CoinCollectionCT.setField(numberOfBrassCoinsField, i);
            getNumberOfBrassCoinsMT.assertReturnValueEquals(i);
        }
    }

    @Test
    @DisplayName("6 | getNumberOfCopperCoins()")
    public void test06() {
        CoinCollectionCT.resolve();

        Field numberOfCopperCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester getNumberOfCopperCoinsMT = new MethodTester(
            CoinCollectionCT, "getNumberOfCopperCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getNumberOfCopperCoinsMT.resolveMethod();

        for (int i = 0; i < 10; i++){
            CoinCollectionCT.setField(numberOfCopperCoinsField, i);
            getNumberOfCopperCoinsMT.assertReturnValueEquals(i);
        }
    }

    @Test
    @DisplayName("7 | getNumberOfCoinsOfType()")
    public void test07() {
        CoinCollectionCT.resolve();

        Field numberOfSilverCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester mt = new MethodTester(
            CoinCollectionCT, "getNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            int.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class)))).verify();
        mt.resolveMethod();

        for (int i = 0; i <= 20; i++) {
            CoinCollectionCT.setField(numberOfSilverCoinsField, i);
            mt.assertReturnValueEquals(
                i,
                CoinType.SILVER);

            CoinCollectionCT.setField(numberOfBrassCoinsField, i);
            mt.assertReturnValueEquals(
                i,
                CoinType.BRASS);

            CoinCollectionCT.setField(numberOfCopperCoinsField, i);
            mt.assertReturnValueEquals(
                i,
                CoinType.COPPER);
        }
    }

    @Test
    @DisplayName("8 | setNumberOfCoinsOfType()")
    public void test08() {
        CoinCollectionCT.resolve();

        Field numberOfSilverCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester setNumberOfCoinTypesMT = new MethodTester(
            CoinCollectionCT, "setNumberOfCoinsOfType", 0.8, Modifier.PUBLIC,
            void.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class),
            new ParameterMatcher("number", 0.8, int.class)
        ))).verify();
        setNumberOfCoinTypesMT.resolveMethod();


        // Test Values and Robot Method Call
        for (int i = 0; i <= 20; i++) {
            CoinCollectionCT.setField(numberOfSilverCoinsField, 0);
            CoinCollectionCT.setField(numberOfBrassCoinsField, 0);
            CoinCollectionCT.setField(numberOfCopperCoinsField, 0);
            setNumberOfCoinTypesMT.invoke(CoinType.SILVER, i);
            CoinCollectionCT.assertFieldEquals(numberOfSilverCoinsField, i);

            setNumberOfCoinTypesMT.invoke(CoinType.BRASS, i);
            CoinCollectionCT.assertFieldEquals(numberOfBrassCoinsField, i);

            setNumberOfCoinTypesMT.invoke(CoinType.COPPER, i);
            CoinCollectionCT.assertFieldEquals(numberOfCopperCoinsField, i);
        }

        // if negative number, set it to 0
        setNumberOfCoinTypesMT.invoke(CoinType.COPPER, -1);
        CoinCollectionCT.assertFieldEquals(numberOfCopperCoinsField, 0);
    }

    @Test
    @DisplayName("9 | insertCoin()")
    public void test09() {
        CoinCollectionCT.resolve();

        Field numberOfSilverCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester insertCoinMT = new MethodTester(
            CoinCollectionCT, "insertCoin", 0.8, Modifier.PUBLIC,
            void.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class))))
            .verify();
        insertCoinMT.resolveMethod();


        // Test Values and Robot Method Call
        CoinCollectionCT.setField(numberOfSilverCoinsField, 0);
        CoinCollectionCT.setField(numberOfBrassCoinsField, 0);
        CoinCollectionCT.setField(numberOfCopperCoinsField, 0);
        for (int i = 0; i <= 20; i++) {
            insertCoinMT.invoke(CoinType.SILVER);
            CoinCollectionCT.assertFieldEquals(numberOfSilverCoinsField, i + 1);

            insertCoinMT.invoke(CoinType.BRASS);
            CoinCollectionCT.assertFieldEquals(numberOfBrassCoinsField, i + 1);

            insertCoinMT.invoke(CoinType.COPPER);
            CoinCollectionCT.assertFieldEquals(numberOfCopperCoinsField, i + 1);
        }
    }

    @Test
    @DisplayName("10 | removeCoin()")
    public void test10() {
        CoinCollectionCT.resolve();

        Field numberOfSilverCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfSilverCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfBrassCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfBrassCoins", 0.8,
                Modifier.PRIVATE, int.class));
        Field numberOfCopperCoinsField = CoinCollectionCT
            .resolveAttribute(new AttributeMatcher("numberOfCopperCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester removeCoinMT = new MethodTester(
            CoinCollectionCT, "removeCoin", 0.8, Modifier.PUBLIC,
            void.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", minSim, CoinType.class))))
            .verify();
        removeCoinMT.resolveMethod();


        // Test Values and Robot Method Call
        CoinCollectionCT.setField(numberOfSilverCoinsField, 20);
        CoinCollectionCT.setField(numberOfBrassCoinsField, 20);
        CoinCollectionCT.setField(numberOfCopperCoinsField, 20);
        for (int i = 20; i > 0; i--) {
            removeCoinMT.invoke(CoinType.SILVER);
            CoinCollectionCT.assertFieldEquals(numberOfSilverCoinsField, i - 1);

            removeCoinMT.invoke(CoinType.BRASS);
            CoinCollectionCT.assertFieldEquals(numberOfBrassCoinsField, i - 1);

            removeCoinMT.invoke(CoinType.COPPER);
            CoinCollectionCT.assertFieldEquals(numberOfCopperCoinsField, i - 1);
        }

        // For negative numbers
        removeCoinMT.invoke(CoinType.SILVER);
        CoinCollectionCT.assertFieldEquals(numberOfSilverCoinsField, 0);
        removeCoinMT.invoke(CoinType.BRASS);
        CoinCollectionCT.assertFieldEquals(numberOfBrassCoinsField, 0);
        removeCoinMT.invoke(CoinType.COPPER);
        CoinCollectionCT.assertFieldEquals(numberOfCopperCoinsField, 0);

    }
}
