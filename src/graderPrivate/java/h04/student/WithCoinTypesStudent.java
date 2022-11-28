package h04.student;

import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.match.Matcher;
import org.tudalgo.algoutils.tutor.general.reflections.MethodLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import java.util.concurrent.atomic.AtomicReference;

import static h04.Tests.stringMatcher;
import static h04.student.H01Student.linkToH01;
import static org.tudalgo.algoutils.tutor.general.Messages.UNEXPECTED_EXCEPTION;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertMethodExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertTypeExists;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.hasModifiers;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.NON_STATIC;

public interface WithCoinTypesStudent {

    AtomicReference<TypeLink> linkToWithCoinTypes = new AtomicReference<>();
    AtomicReference<MethodLink> linkToGetCoinTypes = new AtomicReference<>();
    AtomicReference<MethodLink> linkToSetNumberOfCoinsOfType = new AtomicReference<>();

    static TypeLink linkToWithCoinTypes() {
        if (linkToWithCoinTypes.get() != null) {
            return linkToWithCoinTypes.get();
        }
        linkToWithCoinTypes.set(assertTypeExists(linkToH01(), stringMatcher("WithCoinTypes")));
        return linkToWithCoinTypes.get();
    }

    static MethodLink linkToGetNumberOfCoinsOfType() {
        if (linkToGetCoinTypes.get() != null) {
            return linkToGetCoinTypes.get();
        }
        linkToGetCoinTypes.set(assertMethodExists(linkToWithCoinTypes(), stringMatcher("getNumberOfCoinsOfType").and(hasModifiers(NON_STATIC))));
        return linkToGetCoinTypes.get();
    }

    static MethodLink linkToSetNumberOfCoinsOfType() {
        if (linkToSetNumberOfCoinsOfType.get() != null) {
            return linkToSetNumberOfCoinsOfType.get();
        }
        linkToSetNumberOfCoinsOfType.set(assertMethodExists(
            linkToWithCoinTypes(),
            stringMatcher("setNumberOfCoinsOfType").and(hasModifiers(NON_STATIC)).and(Matcher.of(m -> m.typeList().size() == 2)))
        );
        return linkToSetNumberOfCoinsOfType.get();
    }

    default int getNumberOfCoinsOfType(Object type) {
        return Assertions2.callObject(
            () -> linkToGetNumberOfCoinsOfType().invoke(instance(), type),
            Assertions2.contextBuilder().subject(linkToGetNumberOfCoinsOfType()).add(context()).build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    default void setNumberOfCoinsOfType(Object type, int numberOfCoinsOfType) {
        Assertions2.call(
            () -> linkToSetNumberOfCoinsOfType().invoke(instance(), type, numberOfCoinsOfType),
            Assertions2.contextBuilder().subject(linkToSetNumberOfCoinsOfType()).add(context()).build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    Context context();

    Object instance();
}
