package h04.student;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;
import org.mockito.Mockito;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.reflections.ConstructorLink;
import org.tudalgo.algoutils.tutor.general.reflections.FieldLink;
import org.tudalgo.algoutils.tutor.general.reflections.MethodLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import static h04.Tests.stringMatcher;
import static h04.student.H01Student.linkToH01;
import static h04.student.More.linkToDirection;
import static h04.student.More.linkToInt;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.tudalgo.algoutils.tutor.general.Messages.UNEXPECTED_EXCEPTION;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.callObject;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertConstructorExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertFieldExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertMethodExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertTypeExists;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.hasModifiers;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameTypes;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.NON_STATIC;

public class RobotWithCoinTypesAndRefStateOneStudent extends RobotWithCoinTypesStudent {

    public RobotWithCoinTypesAndRefStateOneStudent(
        int x,
        int y,
        Direction direction,
        int numberOfSilverCoins,
        int numberOfBrassCoins,
        int numberOfCopperCoins,
        boolean mocked
    ) {
        context = contextBuilder()
            .subject(linkToRobotWithCoinTypesAndRefStateOneConstructor())
            .add("x", x)
            .add("y", y)
            .add("direction", direction)
            .add("numberOfSilverCoins", numberOfSilverCoins)
            .add("numberOfBrassCoins", numberOfBrassCoins)
            .add("numberOfCopperCoins", numberOfCopperCoins)
            .build();
        if (mocked) {
            instance = Mockito.mock(linkToRobotWithCoinTypesAndRefStateOne().reflection(), CALLS_REAL_METHODS);
            x(x);
            y(y);
            direction(direction);
            numberOfSilverCoins(numberOfSilverCoins);
            numberOfBrassCoins(numberOfBrassCoins);
            numberOfCopperCoins(numberOfCopperCoins);
            refX(x);
            refY(y);
            refDirection(direction);
            refNumberOfCoins(numberOfCopperCoins + numberOfBrassCoins + numberOfSilverCoins);
            numberOfCoins(numberOfCopperCoins + numberOfBrassCoins + numberOfSilverCoins);
            RobotStudent.linkToRobotWorld().set(instance, World.getGlobalWorld());
            RobotStudent.linkToNumberOfCoins().set(instance, numberOfBrassCoins + numberOfCopperCoins + numberOfSilverCoins);
            World.getGlobalWorld().addRobot((Robot) instance);
        } else {
            this.instance = callObject(
                () -> linkToRobotWithCoinTypesAndRefStateOneConstructor().invoke(
                    x,
                    y,
                    direction,
                    numberOfSilverCoins,
                    numberOfBrassCoins,
                    numberOfCopperCoins
                ),
                context,
                r -> UNEXPECTED_EXCEPTION
            );
        }
    }

    public RobotWithCoinTypesAndRefStateOneStudent(RobotWithCoinTypesData data, boolean mocked) {
        this(
            data.x(),
            data.y(),
            data.direction(),
            data.numberOfSilverCoins(),
            data.numberOfBrassCoins(),
            data.numberOfCopperCoins(),
            mocked
        );
    }

    private static TypeLink linkToRobotWithCoinTypesAndRefStateOne;
    private static FieldLink linkToRefX;
    private static FieldLink linkToRefY;
    private static FieldLink linkToRefDirection;
    private static FieldLink linkToRefNumberOfCoins;
    private static ConstructorLink linkToRobotWithCoinTypesAndRefStateOneConstructor;
    private static MethodLink linkToGetDiffX;
    private static MethodLink linkToGetDiffY;
    private static MethodLink linkToGetDiffNumberOfCoins;
    private static MethodLink linkToGetDiffDirection;
    private static MethodLink linkToSetCurrentStateAsReferenceState;

    public static TypeLink linkToRobotWithCoinTypesAndRefStateOne() {
        if (linkToRobotWithCoinTypesAndRefStateOne != null) {
            return linkToRobotWithCoinTypesAndRefStateOne;
        }
        return linkToRobotWithCoinTypesAndRefStateOne = assertTypeExists(linkToH01(), stringMatcher("RobotWithCoinTypesAndRefStateOne"));
    }

    public int refX() {
        return linkToRefX().get(instance);
    }

    public void refX(int refX) {
        linkToRefX().set(instance, refX);
    }

    public int refY() {
        return linkToRefY().get(instance);
    }

    public void refY(int refY) {
        linkToRefY().set(instance, refY);
    }

    public Direction refDirection() {
        return linkToRefDirection().get(instance);
    }

    public void refDirection(Direction refDirection) {
        linkToRefDirection().set(instance, refDirection);
    }

    public int refNumberOfCoins() {
        return linkToRefNumberOfCoins().get(instance);
    }

    public void refNumberOfCoins(int refNumberOfCoins) {
        linkToRefNumberOfCoins().set(instance, refNumberOfCoins);
    }

    public static FieldLink linkToRefX() {
        if (linkToRefX != null) {
            return linkToRefX;
        }
        return linkToRefX = assertFieldExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("refX").and(hasModifiers(NON_STATIC)).and(sameType(linkToInt()))
        );
    }

    public static FieldLink linkToRefY() {
        if (linkToRefY != null) {
            return linkToRefY;
        }
        return linkToRefY = assertFieldExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("refY").and(hasModifiers(NON_STATIC)).and(sameType(linkToInt()))
        );
    }

    public int getDiffX() {
        return callObject(
            () -> linkToGetDiffX().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public static FieldLink linkToRefDirection() {
        if (linkToRefDirection != null) {
            return linkToRefDirection;
        }
        return linkToRefDirection = assertFieldExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("refDirection").and(hasModifiers(NON_STATIC)).and(sameType(linkToDirection()))
        );
    }

    public static FieldLink linkToRefNumberOfCoins() {
        if (linkToRefNumberOfCoins != null) {
            return linkToRefNumberOfCoins;
        }
        return linkToRefNumberOfCoins = assertFieldExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("refNumberOfCoins").and(hasModifiers(NON_STATIC)).and(sameType(linkToInt()))
        );
    }

    public int getDiffY() {
        return callObject(
            () -> linkToGetDiffY().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public static ConstructorLink linkToRobotWithCoinTypesAndRefStateOneConstructor() {
        if (linkToRobotWithCoinTypesAndRefStateOneConstructor != null) {
            return linkToRobotWithCoinTypesAndRefStateOneConstructor;
        }
        return linkToRobotWithCoinTypesAndRefStateOneConstructor = assertConstructorExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            sameTypes(
                linkToInt(),
                linkToInt(),
                linkToDirection(),
                linkToInt(),
                linkToInt(),
                linkToInt()
            )
        );
    }

    public MethodLink linkToGetDiffX() {
        if (linkToGetDiffX != null) {
            return linkToGetDiffX;
        }
        return linkToGetDiffX = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("getDiffX").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToInt()))
        );
    }

    public int getDiffNumberOfCoins() {
        return callObject(
            () -> linkToGetDiffNumberOfCoins().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public MethodLink linkToGetDiffY() {
        if (linkToGetDiffY != null) {
            return linkToGetDiffY;
        }
        return linkToGetDiffY = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("getDiffY").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToInt()))
        );
    }

    public MethodLink linkToGetDiffNumberOfCoins() {
        if (linkToGetDiffNumberOfCoins != null) {
            return linkToGetDiffNumberOfCoins;
        }
        return linkToGetDiffNumberOfCoins = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("getDiffNumberOfCoins").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToInt()))
        );
    }

    public Direction getDiffDirection() {
        return callObject(
            () -> linkToGetDiffDirection().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public MethodLink linkToGetDiffDirection() {
        if (linkToGetDiffDirection != null) {
            return linkToGetDiffDirection;
        }
        return linkToGetDiffDirection = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("getDiffDirection").and(hasModifiers(NON_STATIC).and(sameTypes()).and(sameType(linkToDirection())))
        );
    }

    public MethodLink linkToSetCurrentStateAsReferenceState() {
        if (linkToSetCurrentStateAsReferenceState != null) {
            return linkToSetCurrentStateAsReferenceState;
        }
        return linkToSetCurrentStateAsReferenceState = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateOne(),
            stringMatcher("setCurrentStateAsReferenceState").and(hasModifiers(NON_STATIC)).and(sameTypes())
        );
    }

    public void setCurrentStateAsReferenceState() {
        callObject(
            () -> linkToSetCurrentStateAsReferenceState().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    @Override
    public Object instance() {
        return instance;
    }

    @Override
    public Context context() {
        return context;
    }
}
