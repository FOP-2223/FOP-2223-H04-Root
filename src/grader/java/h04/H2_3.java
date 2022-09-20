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
@DisplayName("H2_3")
public class H2_3 {

    public final static double minSim = 0.8d;

    public final static ClassTester<Object> RobotWithCoinTypesAndRefState2CT = new ClassTester("h04",
        "RobotWithCoinTypesAndRefState2", minSim, Modifier.PUBLIC,
        RobotWithCoinTypes.class,
        new ArrayList<>(List.of(new IdentifierMatcher("RobotWithReferenceState", "h04", minSim))));
    public final static ClassTester<?> RobotWithCoinTypesCT = new ClassTester<>("h04",
        "RobotWithCoinTypes", minSim, Modifier.PUBLIC);
    public final static ClassTester<Object> refRobotCT = new ClassTester("h04",
        "ReferenceRobot", minSim, Modifier.PUBLIC,
        Robot.class, null);

    final String class_name = "RobotWithCoinTypesAndRefState2";

    public static void setupWorld() {
        World.reset();
        World.setSize(15, 15);
        World.setDelay(0);
        World.setVisible(false);
    }

    @Test
    @DisplayName("1 | Existenz Klasse " + class_name)
    public void test01() {
        RobotWithCoinTypesAndRefState2CT.setSuperClass((Class<Object>) RobotWithCoinTypesCT.assureClassResolved().getTheClass());
        RobotWithCoinTypesAndRefState2CT.setImplementsInterfaces(
            new ArrayList<>(List.of(new IdentifierMatcher("RobotWithReferenceState", "h04", minSim))));
        RobotWithCoinTypesAndRefState2CT.verify(1.0d);
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

        RobotWithCoinTypesAndRefState2CT.assureClassResolved();
        var constructor = (Constructor<Object>) RobotWithCoinTypesAndRefState2CT.resolveConstructor(parameterMatcher);
        ((ClassTester<Object>) RobotWithCoinTypesAndRefState2CT).assertConstructorValid(constructor, Modifier.PUBLIC,
            parameterMatcher);

        Field refRobotField = RobotWithCoinTypesAndRefState2CT
            .resolveAttribute(new AttributeMatcher("referenceRobot", 0.8,
                Modifier.PRIVATE, ReferenceRobot.class));

        MethodTester getRefXMT = new MethodTester(
           refRobotCT, "getRefX", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefXMT.resolveMethod();

        MethodTester getRefYMT = new MethodTester(
            refRobotCT, "getRefY", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefYMT.resolveMethod();

        MethodTester getRefDirectionMT = new MethodTester(
            refRobotCT, "getRefDirection", 0.8, Modifier.PUBLIC,
            Direction.class).verify();
        getRefDirectionMT.resolveMethod();

        MethodTester getRefNumberOfCoinsMT = new MethodTester(
            refRobotCT, "getRefNumberOfCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefNumberOfCoinsMT.resolveMethod();

        refRobotCT.resolve();
        Field direction = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refDirection"));
        refRobotCT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refX"));
        refRobotCT.setField(x, 0);
        Field y = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refY"));
        refRobotCT.setField(y, 0);
        Field coins = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refNumberOfCoins"));
        refRobotCT.setField(coins, 6);

        setupWorld();

        // Valid Value
        ((ClassTester<Object>) RobotWithCoinTypesAndRefState2CT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance(0, 0, Direction.UP, 1, 2, 3)));

        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        getRefXMT.assertReturnValueEquals(0);
        getRefYMT.assertReturnValueEquals(0);
        getRefDirectionMT.assertReturnValueEquals(Direction.UP);
        getRefNumberOfCoinsMT.assertReturnValueEquals(6);

        // Bigger Value
        ((ClassTester<Object>) RobotWithCoinTypesAndRefState2CT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance( 4, 4, Direction.DOWN, 10, 20, 30)));

        refRobotCT.setField(direction, Direction.DOWN);
        refRobotCT.setField(x, 4);
        refRobotCT.setField(y, 4);
        refRobotCT.setField(coins, 60);

        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        getRefXMT.assertReturnValueEquals(4);
        getRefYMT.assertReturnValueEquals(4);
        getRefDirectionMT.assertReturnValueEquals(Direction.DOWN);
        getRefNumberOfCoinsMT.assertReturnValueEquals(60);
    }

    @Test
    @DisplayName("3 | getDiffY()")
    public void test03() {
        RobotWithCoinTypesAndRefState2CT.resolve();
        refRobotCT.resolve();

        Field refRobotField = RobotWithCoinTypesAndRefState2CT
            .resolveAttribute(new AttributeMatcher("referenceRobot", 0.8,
                Modifier.PRIVATE, ReferenceRobot.class));

        MethodTester getRefYMT = new MethodTester(
            refRobotCT, "getRefY", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefYMT.resolveMethod();

        Field yRef = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refY"));

        MethodTester refYMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "getDiffY", 0.8, Modifier.PUBLIC,
            int.class).verify();
        refYMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState2CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState2CT.getClassInstance());


        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            refRobotCT.setField(yRef, 0);
            RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
            moveMT.invoke();
            getRefYMT.assertReturnValueEquals(0);
        }

        // Test correct values, when robot moves
        // Direction UP
        refRobotCT.setField(yRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(0);
            refYMT.assertReturnValueEquals(i);
            moveMT.invoke();
        }

        refRobotCT.setField(yRef, 1);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(1);
            refYMT.assertReturnValueEquals(i - 1);
            moveMT.invoke();
        }

        // Direction DOWN
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.DOWN);
        RobotWithCoinTypesAndRefState2CT.setField(x, 10);
        RobotWithCoinTypesAndRefState2CT.setField(y, 10);
        refRobotCT.setField(yRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(0);
            refYMT.assertReturnValueEquals(10-i);
            moveMT.invoke();
        }

        refRobotCT.setField(yRef, 10);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 10);
        RobotWithCoinTypesAndRefState2CT.setField(y, 10);

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(10);
            refYMT.assertReturnValueEquals(-i);
            moveMT.invoke();
        }

        // Direction LEFT
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.LEFT);
        RobotWithCoinTypesAndRefState2CT.setField(x, 10);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);
        refRobotCT.setField(yRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(0);
            refYMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        refRobotCT.setField(yRef, 10);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 10);
        RobotWithCoinTypesAndRefState2CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(10);
            refYMT.assertReturnValueEquals(-5);
            moveMT.invoke();
        }

        // Direction RIGHT
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.RIGHT);
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);
        refRobotCT.setField(yRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(0);
            refYMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        refRobotCT.setField(yRef, 10);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        RobotWithCoinTypesAndRefState2CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            getRefYMT.assertReturnValueEquals(10);
            refYMT.assertReturnValueEquals(-5);
            moveMT.invoke();
        }
    }

    @Test
    @DisplayName("4 | getDiffX()")
    public void test04() {
        RobotWithCoinTypesAndRefState2CT.resolve();
        refRobotCT.resolve();

        Field refRobotField = RobotWithCoinTypesAndRefState2CT
            .resolveAttribute(new AttributeMatcher("referenceRobot", 0.8,
                Modifier.PRIVATE, ReferenceRobot.class));

        MethodTester getRefXMT = new MethodTester(
            refRobotCT, "getRefX", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefXMT.resolveMethod();

        Field xRef = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refX"));

        MethodTester refXMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "getDiffX", 0.8, Modifier.PUBLIC,
            int.class).verify();
        refXMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState2CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState2CT.getClassInstance());


        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            refRobotCT.setField(xRef, i);
            RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
            moveMT.invoke();
            getRefXMT.assertReturnValueEquals(i);
        }

        // Test correct values, when robot moves
        // Direction UP
        refRobotCT.setField(xRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(0);
            refXMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        refRobotCT.setField(xRef, 10);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 5);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(10);
            refXMT.assertReturnValueEquals(-5);
            moveMT.invoke();
        }

        // Direction DOWN
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.DOWN);
        RobotWithCoinTypesAndRefState2CT.setField(x, 5);
        RobotWithCoinTypesAndRefState2CT.setField(y, 10);
        refRobotCT.setField(xRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(0);
            refXMT.assertReturnValueEquals(5);
            moveMT.invoke();
        }

        refRobotCT.setField(xRef, 10);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 10);
        RobotWithCoinTypesAndRefState2CT.setField(y, 10);

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(10);
            refXMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        // Direction LEFT
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.LEFT);
        RobotWithCoinTypesAndRefState2CT.setField(x, 10);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);
        refRobotCT.setField(xRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(0);
            refXMT.assertReturnValueEquals(10 - i);
            moveMT.invoke();
        }

        refRobotCT.setField(xRef, 10);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 10);
        RobotWithCoinTypesAndRefState2CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(10);
            refXMT.assertReturnValueEquals(-i);
            moveMT.invoke();
        }

        // Direction RIGHT
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.RIGHT);
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);
        refRobotCT.setField(xRef, 0);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(0);
            refXMT.assertReturnValueEquals(i);
            moveMT.invoke();
        }

        refRobotCT.setField(xRef, 10);
        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        RobotWithCoinTypesAndRefState2CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            getRefXMT.assertReturnValueEquals(10);
            refXMT.assertReturnValueEquals(i - 10);
            moveMT.invoke();
        }
    }

    @Test
    @DisplayName("5 | Attribute refX, refY, refDirection, refNumberOfCoins")
    public void test05() {
        RobotWithCoinTypesAndRefState2CT.resolve();
        for (var fieldMatcher : new AttributeMatcher[]{
            new AttributeMatcher("referenceRobot", 0.8, Modifier.PRIVATE, ReferenceRobot.class)
        }) {
            RobotWithCoinTypesAndRefState2CT.resolveAttribute(fieldMatcher);
        }
    }

    @Test
    @DisplayName("6 | setCurrentStateAsReferenceState()")
    public void test06() {
        RobotWithCoinTypesAndRefState2CT.resolve();

        Field refRobotField = RobotWithCoinTypesAndRefState2CT
            .resolveAttribute(new AttributeMatcher("referenceRobot", 0.8,
                Modifier.PRIVATE, ReferenceRobot.class));

        MethodTester getRefXMT = new MethodTester(
            refRobotCT, "getRefX", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefXMT.resolveMethod();

        MethodTester getRefYMT = new MethodTester(
            refRobotCT, "getRefY", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefYMT.resolveMethod();

        MethodTester getRefDirectionMT = new MethodTester(
            refRobotCT, "getRefDirection", 0.8, Modifier.PUBLIC,
            Direction.class).verify();
        getRefDirectionMT.resolveMethod();

        MethodTester getRefNumberOfCoinsMT = new MethodTester(
            refRobotCT, "getRefNumberOfCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefNumberOfCoinsMT.resolveMethod();

        refRobotCT.resolve();
        Field refDirection = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refDirection"));

        MethodTester setCurrentStateAsReferenceStateMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "setCurrentStateAsReferenceState", 0.8, Modifier.PUBLIC,
            void.class).verify();
        setCurrentStateAsReferenceStateMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState2CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);
        Field coins = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("numberOfCoins"));
        RobotWithCoinTypesAndRefState2CT.setField(coins, 10);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState2CT.getClassInstance());

        // Test if X changes
        for(int i = 0; i < 10; i++){
            RobotWithCoinTypesAndRefState2CT.setField(x, i);
            RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());
            setCurrentStateAsReferenceStateMT.invoke();
            getRefXMT.assertReturnValueEquals(i);
        }

        // Test if Y changes
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.RIGHT);
        for(int i = 0; i < 10; i++){
            RobotWithCoinTypesAndRefState2CT.setField(y, i);
            setCurrentStateAsReferenceStateMT.invoke();
            getRefYMT.assertReturnValueEquals(i);
        }

        // Test if Direction changes
        refRobotCT.setField(refDirection, Direction.UP);
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.UP);
        setCurrentStateAsReferenceStateMT.invoke();
        getRefDirectionMT.assertReturnValueEquals(Direction.UP);
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.RIGHT);
        setCurrentStateAsReferenceStateMT.invoke();
        getRefDirectionMT.assertReturnValueEquals(Direction.RIGHT);
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.DOWN);
        setCurrentStateAsReferenceStateMT.invoke();
        getRefDirectionMT.assertReturnValueEquals(Direction.DOWN);
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.LEFT);
        setCurrentStateAsReferenceStateMT.invoke();
        getRefDirectionMT.assertReturnValueEquals(Direction.LEFT);


        // Test if numberOfCoins changes
        for(int i = 10; i > 0; i--){
            RobotWithCoinTypesAndRefState2CT.setField(coins, i);
            setCurrentStateAsReferenceStateMT.invoke();
            getRefNumberOfCoinsMT.assertReturnValueEquals(i);
        }
    }

    @Test
    @DisplayName("7 | getDiffDirection()")
    public void test07() {
        RobotWithCoinTypesAndRefState2CT.resolve();
        refRobotCT.resolve();

        Field refRobotField = RobotWithCoinTypesAndRefState2CT
            .resolveAttribute(new AttributeMatcher("referenceRobot", 0.8,
                Modifier.PRIVATE, ReferenceRobot.class));

        MethodTester getRefDirectionMT = new MethodTester(
            refRobotCT, "getRefDirection", 0.8, Modifier.PUBLIC,
            Direction.class).verify();
        getRefDirectionMT.resolveMethod();

        Field directionRef = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refDirection"));

        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        MethodTester refDirectionMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "getDiffDirection", 0.8, Modifier.PUBLIC,
            Direction.class).verify();
        refDirectionMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        MethodTester turnLeftMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "turnLeft", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        turnLeftMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState2CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState2CT.getClassInstance());

        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            refRobotCT.setField(directionRef, Direction.UP);
            moveMT.invoke();
            getRefDirectionMT.assertReturnValueEquals(Direction.UP);
        }

        // Reference Direction: UP
        refDirectionMT.assertReturnValueEquals(Direction.UP);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.LEFT);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.DOWN);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.RIGHT);

        // Reference Direction: LEFT
        refRobotCT.setField(directionRef, Direction.LEFT);
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.LEFT);
        refDirectionMT.assertReturnValueEquals(Direction.UP);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.LEFT);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.DOWN);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.RIGHT);

        // Reference Direction: DOWN
        refRobotCT.setField(directionRef, Direction.DOWN);
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.DOWN);
        refDirectionMT.assertReturnValueEquals(Direction.UP);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.LEFT);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.DOWN);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.RIGHT);

        // Reference Direction: RIGHT
        refRobotCT.setField(directionRef, Direction.RIGHT);
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.RIGHT);
        refDirectionMT.assertReturnValueEquals(Direction.UP);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.LEFT);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.DOWN);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.RIGHT);
    }

    @Test
    @DisplayName("8 | getDiffNumberOfCoins()")
    public void test08() {
        RobotWithCoinTypesAndRefState2CT.resolve();
        refRobotCT.resolve();

        Field refRobotField = RobotWithCoinTypesAndRefState2CT
            .resolveAttribute(new AttributeMatcher("referenceRobot", 0.8,
                Modifier.PRIVATE, ReferenceRobot.class));

        MethodTester getRefNumberofCoinsMT = new MethodTester(
            refRobotCT, "getNumberOfCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        getRefNumberofCoinsMT.resolveMethod();

        Field numberOfCoinsRef = assertDoesNotThrow(()->refRobotCT.getTheClass().getDeclaredField("refNumberOfCoins"));

        RobotWithCoinTypesAndRefState2CT.setField(refRobotField, refRobotCT.getClassInstance());

        MethodTester refNumberOfCoinsMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "getDiffNumberOfCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        refNumberOfCoinsMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        MethodTester putCoinMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "putCoin", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        putCoinMT.resolveMethod();

        MethodTester pickCoinMT = new MethodTester(
            RobotWithCoinTypesAndRefState2CT, "pickCoin", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        pickCoinMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState2CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState2CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState2CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState2CT.setField(y, 0);
        Field coins = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState2CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("numberOfCoins"));
        RobotWithCoinTypesAndRefState2CT.setField(coins, 10);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState2CT.getClassInstance());


        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            refRobotCT.setField(numberOfCoinsRef, i);
            moveMT.invoke();
            getRefNumberofCoinsMT.assertReturnValueEquals(i);
        }

        refRobotCT.setField(numberOfCoinsRef, 10);

        // Test values change if robot puts coin
        int j = -1;
        for (int i = 10; i > 0; i--) {
            putCoinMT.invoke();
            refNumberOfCoinsMT.assertReturnValueEquals(j);
            j --;
        }

        // Test values change if robot picks up coin
        j = -10;
        for (int i = 0; i < 10; i++) {
            j++;
            pickCoinMT.invoke();
            refNumberOfCoinsMT.assertReturnValueEquals(j);
        }
    }
}
