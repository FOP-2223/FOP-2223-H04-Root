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
@DisplayName("H2_2")
public class H2_2 {

    public final static double minSim = 0.8d;

    public final static ClassTester<Object> RobotWithCoinTypesAndRefState1CT = new ClassTester("h04",
        "RobotWithCoinTypesAndRefStateOne", minSim, Modifier.PUBLIC,
        RobotWithCoinTypes.class,
        new ArrayList<>(List.of(new IdentifierMatcher("RobotWithReferenceState", "h04", minSim))));
    public final static ClassTester<?> RobotWithCoinTypesCT = new ClassTester<>("h04",
        "RobotWithCoinTypes", minSim, Modifier.PUBLIC);

    final String class_name = "RobotWithCoinTypesAndRefStateOne";

    public static void setupWorld() {
        World.reset();
        World.setSize(15, 15);
        World.setDelay(0);
        World.setVisible(false);
    }

    @Test
    @DisplayName("1 | Existenz Klasse " + class_name)
    public void test01() {
        RobotWithCoinTypesAndRefState1CT.setSuperClass((Class<Object>) RobotWithCoinTypesCT.assureClassResolved().getTheClass());
        RobotWithCoinTypesAndRefState1CT.setImplementsInterfaces(
            new ArrayList<>(List.of(new IdentifierMatcher("RobotWithReferenceState", "h04", minSim))));
        RobotWithCoinTypesAndRefState1CT.verify(1.0d);
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

        RobotWithCoinTypesAndRefState1CT.assureClassResolved();
        var constructor = (Constructor<Object>) RobotWithCoinTypesAndRefState1CT.resolveConstructor(parameterMatcher);
        ((ClassTester<Object>) RobotWithCoinTypesAndRefState1CT).assertConstructorValid(constructor, Modifier.PUBLIC,
            parameterMatcher);

        Field refXField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refX", 0.8,
                Modifier.PRIVATE, int.class));
        Field refYField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refY", 0.8,
                Modifier.PRIVATE, int.class));
        Field refDirectionField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refDirection", 0.8,
                Modifier.PRIVATE, Direction.class));
        Field refNumberOfCoinsField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refNumberOfCoins", 0.8,
                Modifier.PRIVATE, int.class));

        setupWorld();

        // Valid Value
        ((ClassTester<Object>) RobotWithCoinTypesAndRefState1CT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance(0, 0, Direction.UP, 1, 2, 3)));

        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 0);
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 0);
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refDirectionField, Direction.UP);
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refNumberOfCoinsField, 6);

        // Bigger Value
        ((ClassTester<Object>) RobotWithCoinTypesAndRefState1CT).setClassInstance(assertDoesNotThrow(()
            -> constructor.newInstance( 4, 4, Direction.DOWN, 10, 20, 30)));

        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 4);
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 4);
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refDirectionField, Direction.DOWN);
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refNumberOfCoinsField, 60);
    }

    @Test
    @DisplayName("3 | getDiffY()")
    public void test03() {
        RobotWithCoinTypesAndRefState1CT.resolve();

        Field refYField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refY", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester refYMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "getDiffY", 0.8, Modifier.PUBLIC,
            int.class).verify();
        refYMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState1CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState1CT.getClassInstance());


        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.setField(refYField, i);
            moveMT.invoke();
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, i);
        }

        // Test correct values, when robot moves
        // Direction UP
        RobotWithCoinTypesAndRefState1CT.setField(refYField, 0);
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 0);
            refYMT.assertReturnValueEquals(i);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refYField, 1);
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 1);
            refYMT.assertReturnValueEquals(i - 1);
            moveMT.invoke();
        }

        // Direction DOWN
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.DOWN);
        RobotWithCoinTypesAndRefState1CT.setField(x, 10);
        RobotWithCoinTypesAndRefState1CT.setField(y, 10);
        RobotWithCoinTypesAndRefState1CT.setField(refYField, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 0);
            refYMT.assertReturnValueEquals(10-i);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refYField, 10);
        RobotWithCoinTypesAndRefState1CT.setField(x, 10);
        RobotWithCoinTypesAndRefState1CT.setField(y, 10);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 10);
            refYMT.assertReturnValueEquals(-i);
            moveMT.invoke();
        }

        // Direction LEFT
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.LEFT);
        RobotWithCoinTypesAndRefState1CT.setField(x, 10);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);
        RobotWithCoinTypesAndRefState1CT.setField(refYField, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 0);
            refYMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refYField, 10);
        RobotWithCoinTypesAndRefState1CT.setField(x, 10);
        RobotWithCoinTypesAndRefState1CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 10);
            refYMT.assertReturnValueEquals(-5);
            moveMT.invoke();
        }

        // Direction RIGHT
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.RIGHT);
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);
        RobotWithCoinTypesAndRefState1CT.setField(refYField, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 0);
            refYMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refYField, 10);
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        RobotWithCoinTypesAndRefState1CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, 10);
            refYMT.assertReturnValueEquals(-5);
            moveMT.invoke();
        }
    }

    @Test
    @DisplayName("4 | getDiffX()")
    public void test04() {
        RobotWithCoinTypesAndRefState1CT.resolve();

        Field refXField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refX", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester refXMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "getDiffX", 0.8, Modifier.PUBLIC,
            int.class).verify();
        refXMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState1CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState1CT.getClassInstance());


        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.setField(refXField, i);
            moveMT.invoke();
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, i);
        }

        // Test correct values, when robot moves
        // Direction UP
        RobotWithCoinTypesAndRefState1CT.setField(refXField, 0);
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 0);
            refXMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refXField, 10);
        RobotWithCoinTypesAndRefState1CT.setField(x, 5);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 10);
            refXMT.assertReturnValueEquals(-5);
            moveMT.invoke();
        }

        // Direction DOWN
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.DOWN);
        RobotWithCoinTypesAndRefState1CT.setField(x, 5);
        RobotWithCoinTypesAndRefState1CT.setField(y, 10);
        RobotWithCoinTypesAndRefState1CT.setField(refXField, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 0);
            refXMT.assertReturnValueEquals(5);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refXField, 10);
        RobotWithCoinTypesAndRefState1CT.setField(x, 10);
        RobotWithCoinTypesAndRefState1CT.setField(y, 10);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 10);
            refXMT.assertReturnValueEquals(0);
            moveMT.invoke();
        }

        // Direction LEFT
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.LEFT);
        RobotWithCoinTypesAndRefState1CT.setField(x, 10);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);
        RobotWithCoinTypesAndRefState1CT.setField(refXField, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 0);
            refXMT.assertReturnValueEquals(10 - i);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refXField, 10);
        RobotWithCoinTypesAndRefState1CT.setField(x, 10);
        RobotWithCoinTypesAndRefState1CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 10);
            refXMT.assertReturnValueEquals(-i);
            moveMT.invoke();
        }

        // Direction RIGHT
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.RIGHT);
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);
        RobotWithCoinTypesAndRefState1CT.setField(refXField, 0);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 0);
            refXMT.assertReturnValueEquals(i);
            moveMT.invoke();
        }

        RobotWithCoinTypesAndRefState1CT.setField(refXField, 10);
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        RobotWithCoinTypesAndRefState1CT.setField(y, 5);

        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, 10);
            refXMT.assertReturnValueEquals(i - 10);
            moveMT.invoke();
        }
    }

    @Test
    @DisplayName("5 | Attribute refX, refY, refDirection, refNumberOfCoins")
    public void test05() {
        RobotWithCoinTypesAndRefState1CT.resolve();
        for (var fieldMatcher : new AttributeMatcher[]{
            new AttributeMatcher("refX", 0.8, Modifier.PRIVATE, int.class),
            new AttributeMatcher("refY", 0.8, Modifier.PRIVATE, int.class),
            new AttributeMatcher("refDirection", 0.8, Modifier.PRIVATE, Direction.class),
            new AttributeMatcher("refNumberOfCoins", 0.8, Modifier.PRIVATE, int.class)
        }) {
            RobotWithCoinTypesAndRefState1CT.resolveAttribute(fieldMatcher);
        }
    }

    @Test
    @DisplayName("6 | setCurrentStateAsReferenceState()")
    public void test06() {
        RobotWithCoinTypesAndRefState1CT.resolve();

        Field refXField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refX", 0.8,
                Modifier.PRIVATE, int.class));

        Field refYField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refY", 0.8,
                Modifier.PRIVATE, int.class));

        Field refDirectionField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refDirection", 0.8,
                Modifier.PRIVATE, Direction.class));

        Field refNumberOfCoinsField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refNumberOfCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester setCurrentStateAsReferenceStateMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "setCurrentStateAsReferenceState", 0.8, Modifier.PUBLIC,
            void.class).verify();
        setCurrentStateAsReferenceStateMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState1CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);
        Field coins = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("numberOfCoins"));
        RobotWithCoinTypesAndRefState1CT.setField(coins, 10);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState1CT.getClassInstance());

        // Test if X changes
        for(int i = 0; i < 10; i++){
            RobotWithCoinTypesAndRefState1CT.setField(x, i);
            setCurrentStateAsReferenceStateMT.invoke();
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refXField, i);
        }

        // Test if Y changes
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.RIGHT);
        for(int i = 0; i < 10; i++){
            RobotWithCoinTypesAndRefState1CT.setField(y, i);
            setCurrentStateAsReferenceStateMT.invoke();
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refYField, i);
        }

        // Test if Direction changes
        RobotWithCoinTypesAndRefState1CT.setField(refDirectionField, Direction.UP);
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.UP);
        setCurrentStateAsReferenceStateMT.invoke();
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refDirectionField, Direction.UP);
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.RIGHT);
        setCurrentStateAsReferenceStateMT.invoke();
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refDirectionField, Direction.RIGHT);
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.DOWN);
        setCurrentStateAsReferenceStateMT.invoke();
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refDirectionField, Direction.DOWN);
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.LEFT);
        setCurrentStateAsReferenceStateMT.invoke();
        RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refDirectionField, Direction.LEFT);


        // Test if numberOfCoins changes
        for(int i = 10; i > 0; i--){
            RobotWithCoinTypesAndRefState1CT.setField(coins, i);
            setCurrentStateAsReferenceStateMT.invoke();
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refNumberOfCoinsField, i);
        }
    }

    @Test
    @DisplayName("7 | getDiffDirection()")
    public void test07() {
        RobotWithCoinTypesAndRefState1CT.resolve();

        Field refDirectionField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refDirection", 0.8,
                Modifier.PRIVATE, Direction.class));

        MethodTester refDirectionMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "getDiffDirection", 0.8, Modifier.PUBLIC,
            Direction.class).verify();
        refDirectionMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        MethodTester turnLeftMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "turnLeft", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        turnLeftMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState1CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState1CT.getClassInstance());

        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.setField(refDirectionField, Direction.UP);
            moveMT.invoke();
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refDirectionField, Direction.UP);
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
        RobotWithCoinTypesAndRefState1CT.setField(refDirectionField, Direction.LEFT);
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.LEFT);
        refDirectionMT.assertReturnValueEquals(Direction.UP);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.LEFT);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.DOWN);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.RIGHT);

        // Reference Direction: DOWN
        RobotWithCoinTypesAndRefState1CT.setField(refDirectionField, Direction.DOWN);
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.DOWN);
        refDirectionMT.assertReturnValueEquals(Direction.UP);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.LEFT);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.DOWN);
        turnLeftMT.invoke();
        refDirectionMT.assertReturnValueEquals(Direction.RIGHT);

        // Reference Direction: RIGHT
        RobotWithCoinTypesAndRefState1CT.setField(refDirectionField, Direction.RIGHT);
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.RIGHT);
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
        RobotWithCoinTypesAndRefState1CT.resolve();

        Field refNumberOfCoinsField = RobotWithCoinTypesAndRefState1CT
            .resolveAttribute(new AttributeMatcher("refNumberOfCoins", 0.8,
                Modifier.PRIVATE, int.class));

        MethodTester refNumberOfCoinsMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "getDiffNumberOfCoins", 0.8, Modifier.PUBLIC,
            int.class).verify();
        refNumberOfCoinsMT.resolveMethod();

        MethodTester moveMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "move", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        moveMT.resolveMethod();

        MethodTester putCoinMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "putCoin", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        putCoinMT.resolveMethod();

        MethodTester pickCoinMT = new MethodTester(
            RobotWithCoinTypesAndRefState1CT, "pickCoin", 1.0, Modifier.PUBLIC,
            void.class, null, true).verify();
        pickCoinMT.resolveMethod();

        // Prepare World and Robot
        setupWorld();
        Field world = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("world"));
        RobotWithCoinTypesAndRefState1CT.setField(world, World.getGlobalWorld());
        Field direction = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("direction"));
        RobotWithCoinTypesAndRefState1CT.setField(direction, Direction.UP);
        Field x = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("x"));
        RobotWithCoinTypesAndRefState1CT.setField(x, 0);
        Field y = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getSuperclass().getDeclaredField("y"));
        RobotWithCoinTypesAndRefState1CT.setField(y, 0);
        Field coins = assertDoesNotThrow(()->RobotWithCoinTypesAndRefState1CT.getTheClass()
            .getSuperclass().getSuperclass().getDeclaredField("numberOfCoins"));
        RobotWithCoinTypesAndRefState1CT.setField(coins, 10);

        World.getGlobalWorld().addRobot((Robot)RobotWithCoinTypesAndRefState1CT.getClassInstance());


        // Test Values for ref stay same when Robot moves
        for (int i = 0; i < 10; i++) {
            RobotWithCoinTypesAndRefState1CT.setField(refNumberOfCoinsField, i);
            moveMT.invoke();
            RobotWithCoinTypesAndRefState1CT.assertFieldEquals(refNumberOfCoinsField, i);
        }

        RobotWithCoinTypesAndRefState1CT.setField(refNumberOfCoinsField, 10);

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

