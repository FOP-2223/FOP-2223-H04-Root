package h04.student;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;
import h04.ReferenceRobot;
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
import static h04.student.More.linkToReferenceRobot;
import static h04.student.More.linkToVoid;
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

public class RobotWithCoinTypesAndRefStateTwoStudent extends RobotWithCoinTypesStudent {

    public RobotWithCoinTypesAndRefStateTwoStudent(
        int x,
        int y,
        Direction direction,
        int numberOfSilverCoins,
        int numberOfBrassCoins,
        int numberOfCopperCoins,
        boolean mocked
    ) {
        context = contextBuilder()
            .subject(linkToRobotWithCoinTypesAndRefStateTwoConstructor())
            .add("x", x)
            .add("y", y)
            .add("direction", direction)
            .add("numberOfSilverCoins", numberOfSilverCoins)
            .add("numberOfBrassCoins", numberOfBrassCoins)
            .add("numberOfCopperCoins", numberOfCopperCoins)
            .build();
        if (mocked) {
            instance = Mockito.mock(linkToRobotWithCoinTypesAndRefStateTwo().reflection(), CALLS_REAL_METHODS);
            x(x);
            y(y);
            direction(direction);
            numberOfSilverCoins(numberOfSilverCoins);
            numberOfBrassCoins(numberOfBrassCoins);
            numberOfCopperCoins(numberOfCopperCoins);
            refRobot(new ReferenceRobot(x, y, direction, numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins));
            numberOfCoins(numberOfCopperCoins + numberOfBrassCoins + numberOfSilverCoins);
            RobotStudent.linkToRobotWorld().set(instance, World.getGlobalWorld());
            RobotStudent.linkToNumberOfCoins().set(instance, numberOfBrassCoins + numberOfCopperCoins + numberOfSilverCoins);
            World.getGlobalWorld().addRobot((Robot) instance);
        } else {
            this.instance = callObject(
                () -> linkToRobotWithCoinTypesAndRefStateTwoConstructor().invoke(
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

    public RobotWithCoinTypesAndRefStateTwoStudent(RobotWithCoinTypesData data, boolean mocked) {
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

    private static TypeLink linkToRobotWithCoinTypesAndRefStateTwo;
    private static FieldLink linkToRefRobot;
    private static ConstructorLink linkToRobotWithCoinTypesAndRefStateTwoConstructor;
    private static MethodLink linkToGetDiffX;
    private static MethodLink linkToGetDiffY;
    private static MethodLink linkToGetDiffNumberOfCoins;
    private static MethodLink linkToGetDiffNumberOfSilverCoins;
    private static MethodLink linkToSetCurrentStateAsReferenceState;

    public int getDiffX() {
        // TODO
        return callObject(
            () -> linkToGetDiffX().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public static TypeLink linkToRobotWithCoinTypesAndRefStateTwo() {
        if (linkToRobotWithCoinTypesAndRefStateTwo != null) {
            return linkToRobotWithCoinTypesAndRefStateTwo;
        }
        return linkToRobotWithCoinTypesAndRefStateTwo = assertTypeExists(
            linkToH01(),
            stringMatcher("RobotWithCoinTypesAndRefStateTwo")
        );
    }

    public static FieldLink linkToRefRobot() {
        if (linkToRefRobot != null) {
            return linkToRefRobot;
        }
        return linkToRefRobot = assertFieldExists(
            linkToRobotWithCoinTypesAndRefStateTwo(),
            stringMatcher("refRobot").and(hasModifiers(NON_STATIC)).and(sameType(linkToReferenceRobot()))
        );
    }

    public int getDiffY() {
        return callObject(
            () -> linkToGetDiffY().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public static ConstructorLink linkToRobotWithCoinTypesAndRefStateTwoConstructor() {
        if (linkToRobotWithCoinTypesAndRefStateTwoConstructor != null) {
            return linkToRobotWithCoinTypesAndRefStateTwoConstructor;
        }
        return linkToRobotWithCoinTypesAndRefStateTwoConstructor = assertConstructorExists(
            linkToRobotWithCoinTypesAndRefStateTwo(),
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
            linkToRobotWithCoinTypesAndRefStateTwo(),
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
            linkToRobotWithCoinTypesAndRefStateTwo(),
            stringMatcher("getDiffY").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToInt()))
        );
    }

    public MethodLink linkToGetDiffNumberOfCoins() {
        if (linkToGetDiffNumberOfCoins != null) {
            return linkToGetDiffNumberOfCoins;
        }
        return linkToGetDiffNumberOfCoins = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateTwo(),
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
        if (linkToGetDiffNumberOfSilverCoins != null) {
            return linkToGetDiffNumberOfSilverCoins;
        }
        return linkToGetDiffNumberOfSilverCoins = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateTwo(),
            stringMatcher("getDiffDirection").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToDirection()))
        );
    }

    public MethodLink linkToSetCurrentStateAsReferenceState() {
        if (linkToSetCurrentStateAsReferenceState != null) {
            return linkToSetCurrentStateAsReferenceState;
        }
        return linkToSetCurrentStateAsReferenceState = assertMethodExists(
            linkToRobotWithCoinTypesAndRefStateTwo(),
            stringMatcher("setCurrentStateAsReferenceState").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToVoid()))
        );
    }

    public void setCurrentStateAsReferenceState() {
        callObject(
            () -> linkToSetCurrentStateAsReferenceState().invoke(instance),
            context,
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public ReferenceRobot refRobot() {
        return linkToRefRobot().get(instance());
    }

    public void refRobot(ReferenceRobot refRobot) {
        linkToRefRobot().set(instance(), refRobot);
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
