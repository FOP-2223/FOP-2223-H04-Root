package h04.student;

import org.tudalgo.algoutils.tutor.general.reflections.MethodLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import java.util.concurrent.atomic.AtomicReference;

import static h04.Tests.stringMatcher;
import static h04.student.H01Student.linkToH01;
import static h04.student.More.linkToDirection;
import static h04.student.More.linkToInt;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertMethodExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertTypeExists;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.hasModifiers;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameTypes;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.NON_STATIC;

public interface RobotWithReferenceStateStudent {

    AtomicReference<TypeLink> linkToRobotWithReferenceState = new AtomicReference<>();
    AtomicReference<MethodLink> linkToSetCurrentStateAsReferenceState = new AtomicReference<>();
    AtomicReference<MethodLink> linkToGetDiffX = new AtomicReference<>();
    AtomicReference<MethodLink> linkToGetDiffY = new AtomicReference<>();
    AtomicReference<MethodLink> linkToGetDiffDirection = new AtomicReference<>();
    AtomicReference<MethodLink> linkToGetDiffNumberOfCoins = new AtomicReference<>();

    static TypeLink linkToRobotWithReferenceState() {
        if (linkToRobotWithReferenceState.get() != null) {
            return linkToRobotWithReferenceState.get();
        }
        linkToRobotWithReferenceState.set(assertTypeExists(linkToH01(), stringMatcher("RobotWithReferenceState")));
        return linkToRobotWithReferenceState.get();
    }

    static MethodLink linkToSetCurrentStateAsReferenceState() {
        if (linkToSetCurrentStateAsReferenceState.get() != null) {
            return linkToSetCurrentStateAsReferenceState.get();
        }
        linkToSetCurrentStateAsReferenceState.set(assertMethodExists(
            linkToRobotWithReferenceState(),
            stringMatcher("setCurrentStateAsReferenceState").and(hasModifiers(NON_STATIC)).and(sameTypes())
        ));
        return linkToSetCurrentStateAsReferenceState.get();
    }

    static MethodLink linkToGetDiffX() {
        if (linkToGetDiffX.get() != null) {
            return linkToGetDiffX.get();
        }
        linkToGetDiffX.set(assertMethodExists(
            linkToRobotWithReferenceState(),
            stringMatcher("getDiffX").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToInt()))
        ));
        return linkToGetDiffX.get();
    }

    static MethodLink linkToGetDiffY() {
        if (linkToGetDiffY.get() != null) {
            return linkToGetDiffY.get();
        }
        linkToGetDiffY.set(assertMethodExists(
            linkToRobotWithReferenceState(),
            stringMatcher("getDiffY").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToInt()))
        ));
        return linkToGetDiffY.get();
    }

    static MethodLink linkToGetDiffDirection() {
        if (linkToGetDiffDirection.get() != null) {
            return linkToGetDiffDirection.get();
        }
        linkToGetDiffDirection.set(assertMethodExists(
            linkToRobotWithReferenceState(),
            stringMatcher("getDiffDirection").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToDirection()))
        ));
        return linkToGetDiffDirection.get();
    }

    static MethodLink linkToGetDiffNumberOfCoins() {
        if (linkToGetDiffNumberOfCoins.get() != null) {
            return linkToGetDiffNumberOfCoins.get();
        }
        linkToGetDiffNumberOfCoins.set(assertMethodExists(
            linkToRobotWithReferenceState(),
            stringMatcher("getDiffNumberOfCoins").and(hasModifiers(NON_STATIC)).and(sameTypes()).and(sameType(linkToInt()))
        ));
        return linkToGetDiffNumberOfCoins.get();
    }
}
