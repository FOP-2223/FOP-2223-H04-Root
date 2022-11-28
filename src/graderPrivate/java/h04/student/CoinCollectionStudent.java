package h04.student;

import org.mockito.Mockito;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.reflections.ConstructorLink;
import org.tudalgo.algoutils.tutor.general.reflections.FieldLink;
import org.tudalgo.algoutils.tutor.general.reflections.MethodLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import static h04.Tests.stringMatcher;
import static h04.student.CoinTypeStudent.linkToCoinType;
import static h04.student.H01Student.linkToH01;
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
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.CLASS;

public class CoinCollectionStudent implements WithCoinTypesStudent {

    Context context;

    Object instance;

    public CoinCollectionStudent(CoinCollectionData data, boolean mock) {
        context = contextBuilder().subject(linkToCoinCollectionConstructor()).add(Assertions2.context(data)).build();
        if (mock) {
            instance = Mockito.mock(linkToCoinCollection().reflection(), CALLS_REAL_METHODS);
            numberOfCopperCoins(data.numberOfCopperCoins());
            numberOfBrassCoins(data.numberOfBrassCoins());
            numberOfSilverCoins(data.numberOfSilverCoins());
        } else {
            instance = callObject(
                () -> linkToCoinCollectionConstructor().invoke(data.numberOfSilverCoins(), data.numberOfBrassCoins(), data.numberOfCopperCoins()),
                context,
                r -> UNEXPECTED_EXCEPTION
            );
        }
    }

    private static TypeLink linkToCoinCollection;
    private static FieldLink linkToNumberOfSilverCoins;
    private static FieldLink linkToNumberOfBrassCoins;
    private static FieldLink linkToNumberOfCopperCoins;
    private static ConstructorLink linkToCoinCollectionConstructor;
    private static MethodLink linkToGetNumberOfSilverCoins;
    private static MethodLink linkToGetNumberOfBrassCoins;
    private static MethodLink linkToGetNumberOfCopperCoins;
    private static MethodLink linkToInsertCoin;
    private static MethodLink linkToRemoveCoin;

    public static TypeLink linkToCoinCollection() {
        if (linkToCoinCollection != null) {
            return linkToCoinCollection;
        }
        return linkToCoinCollection = assertTypeExists(
            linkToH01(),
            stringMatcher("CoinCollection").and(hasModifiers(CLASS))
        );
    }

    public static FieldLink linkToNumberOfSilverCoins() {
        if (linkToNumberOfSilverCoins != null) {
            return linkToNumberOfSilverCoins;
        }
        return linkToNumberOfSilverCoins = assertFieldExists(
            linkToCoinCollection(),
            stringMatcher("numberOfSilverCoins").and(sameType(linkToInt()))
        );
    }

    public static FieldLink linkToNumberOfBrassCoins() {
        if (linkToNumberOfBrassCoins != null) {
            return linkToNumberOfBrassCoins;
        }
        return linkToNumberOfBrassCoins = assertFieldExists(
            linkToCoinCollection(),
            stringMatcher("numberOfBrassCoins").and(sameType(linkToInt()))
        );
    }

    public static FieldLink linkToNumberOfCopperCoins() {
        if (linkToNumberOfCopperCoins != null) {
            return linkToNumberOfCopperCoins;
        }
        return linkToNumberOfCopperCoins = assertFieldExists(
            linkToCoinCollection(),
            stringMatcher("numberOfCopperCoins").and(sameType(linkToInt()))
        );
    }

    public static ConstructorLink linkToCoinCollectionConstructor() {
        if (linkToCoinCollectionConstructor != null) {
            return linkToCoinCollectionConstructor;
        }
        return linkToCoinCollectionConstructor = assertConstructorExists(
            linkToCoinCollection(),
            sameTypes(
                linkToInt(),
                linkToInt(),
                linkToInt()
            )
        );
    }

    public static MethodLink linkToGetNumberOfSilverCoins() {
        if (linkToGetNumberOfSilverCoins != null) {
            return linkToGetNumberOfSilverCoins;
        }
        return linkToGetNumberOfSilverCoins = assertMethodExists(
            linkToCoinCollection(),
            stringMatcher("getNumberOfSilverCoins").and(sameTypes()).and(sameType(linkToInt()))
        );
    }

    public static MethodLink linkToGetNumberOfBrassCoins() {
        if (linkToGetNumberOfBrassCoins != null) {
            return linkToGetNumberOfBrassCoins;
        }
        return linkToGetNumberOfBrassCoins = assertMethodExists(
            linkToCoinCollection(),
            stringMatcher("getNumberOfBrassCoins").and(sameTypes()).and(sameType(linkToInt()))
        );
    }

    public static MethodLink linkToGetNumberOfCopperCoins() {
        if (linkToGetNumberOfCopperCoins != null) {
            return linkToGetNumberOfCopperCoins;
        }
        return linkToGetNumberOfCopperCoins = assertMethodExists(
            linkToCoinCollection(),
            stringMatcher("getNumberOfCopperCoins").and(sameTypes()).and(sameType(linkToInt()))
        );
    }

    public static MethodLink linkToInsertCoin() {
        if (linkToInsertCoin != null) {
            return linkToInsertCoin;
        }
        return linkToInsertCoin = assertMethodExists(
            linkToCoinCollection(),
            stringMatcher("insertCoin").and(sameTypes(linkToCoinType()))
        );
    }

    public static MethodLink linkToRemoveCoin() {
        if (linkToRemoveCoin != null) {
            return linkToRemoveCoin;
        }
        return linkToRemoveCoin = assertMethodExists(
            linkToCoinCollection(),
            stringMatcher("removeCoin").and(sameTypes(linkToCoinType()))
        );
    }

    public void numberOfCopperCoins(int numberOfCopperCoins) {
        linkToNumberOfCopperCoins().set(instance, numberOfCopperCoins);
    }

    public void numberOfBrassCoins(int numberOfBrassCoins) {
        linkToNumberOfBrassCoins().set(instance, numberOfBrassCoins);
    }

    public void numberOfSilverCoins(int numberOfSilverCoins) {
        linkToNumberOfSilverCoins().set(instance, numberOfSilverCoins);
    }

    public int numberOfCopperCoins() {
        return linkToNumberOfCopperCoins().get(instance);
    }

    public int numberOfBrassCoins() {
        return linkToNumberOfBrassCoins().get(instance);
    }

    public int numberOfSilverCoins() {
        return linkToNumberOfSilverCoins().get(instance);
    }

    public int getNumberOfSilverCoins() {
        return callObject(
            () -> linkToGetNumberOfSilverCoins().invoke(instance),
            contextBuilder().add(context).subject(linkToGetNumberOfSilverCoins()).build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public int getNumberOfBrassCoins() {
        return callObject(
            () -> linkToGetNumberOfBrassCoins().invoke(instance),
            contextBuilder().add(context).subject(linkToGetNumberOfBrassCoins()).build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public int getNumberOfCopperCoins() {
        return callObject(
            () -> linkToGetNumberOfCopperCoins().invoke(instance),
            contextBuilder().add(context).subject(linkToGetNumberOfCopperCoins()).build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public void insertCoin(Object type) {
        callObject(
            () -> linkToInsertCoin().invoke(instance, type),
            contextBuilder().add(context).subject(linkToInsertCoin()).build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public void removeCoin(Object type) {
        callObject(
            () -> linkToRemoveCoin().invoke(instance, type),
            contextBuilder().add(context).subject(linkToRemoveCoin()).build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    @Override
    public Context context() {
        return context;
    }

    @Override
    public Object instance() {
        return instance;
    }

}
