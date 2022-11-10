package h04;

import org.sourcegrade.jagr.api.rubric.*;
import org.tudalgo.algoutils.reflect.MethodTester;

import static h04.H1_1.RobotWithReferenceStateCT;
import static h04.H1_2.WithCoinTypesCT;
import static h04.H2_1.RobotWithCoinTypesCT;
import static h04.H2_2.RobotWithCoinTypesAndRefState1CT;
import static h04.H2_3.RobotWithCoinTypesAndRefState2CT;
import static h04.H2_4.CoinCollectionCT;

public class H04_RubricProvider implements RubricProvider {

    ////////////////////////////////////////////////// H1.1

    public static final Criterion H1_1_T1 = Criterion.builder()
        .shortDescription("Das Interface [[[RobotWithReferenceState]]] ist mitsamt Methoden korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test01")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test02")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test03")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test04")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test05")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test06"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_1 = Criterion.builder()
        .shortDescription("H1.1 | Interface [[[RobotWithReferenceState]]]")
        .addChildCriteria(H1_1_T1)
        .build();

    ////////////////////////////////////////////////// H1.2

    public static final Criterion H1_2_T1 = Criterion.builder()
        .shortDescription("Das Enum [[[CoinType]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H1_2.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_2_T2 = Criterion.builder()
        .shortDescription("Das Interface [[[WithCoinTypes]]] ist mitsamt Methoden korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H1_2.class.getMethod("test01")),
                JUnitTestRef.ofMethod(() -> H1_2.class.getMethod("test03")),
                JUnitTestRef.ofMethod(() -> H1_2.class.getMethod("test04"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_2 = Criterion.builder()
        .shortDescription("H1.2 | Interface [[[WithCoinTypes]]]")
        .addChildCriteria(H1_2_T1, H1_2_T2)
        .build();

    ////////////////////////////////////////////////// H2.1

    public static final Criterion H2_1_T1 = Criterion.builder()
        .shortDescription("Klasse [[[RobotWithCoinTypes]]] ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T2 = Criterion.builder()
        .shortDescription("Die Attribute [[[numberOfSilverCoins]]], [[[numberOfBrassCoins]]], [[[numberOfCopperCoins]]] sind " +
            "korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test05")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T3 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T4 = Criterion.builder()
        .shortDescription("Methode [[[setNumberOfCoins()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test06")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T5 = Criterion.builder()
        .shortDescription("Methode [[[getNumberOfCoinsOfType()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test03")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T6 = Criterion.builder()
        .shortDescription("Methode [[[setNumberOfCoinsOfType()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test04")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T7 = Criterion.builder()
        .shortDescription("Methode [[[putCoin()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test08")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T8 = Criterion.builder()
        .shortDescription("Methode [[[pickCoin()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_1.class.getMethod("test07")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1 = Criterion.builder()
        .shortDescription("H2.1 | Implementierende Roboterklasse mit verschiedenen Münztypen")
        .addChildCriteria(H2_1_T1, H2_1_T2, H2_1_T3, H2_1_T4, H2_1_T5, H2_1_T6, H2_1_T7, H2_1_T8)
        .build();

    ////////////////////////////////////////////////// H2.2

    public static final Criterion H2_2_T1 = Criterion.builder()
        .shortDescription("Klasse [[[RobotWithCoinTypesAndRefStateTwo]]] ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T2 = Criterion.builder()
        .shortDescription("Die Attribute [[[%s]]], [[[%s]]], [[[%s]]] und [[[%s]]] sind korrekt deklariert".formatted(
            "refX", "refY", "refDirection", "refNumberOfCoins"))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test05")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T3 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T4 = Criterion.builder()
        .shortDescription("Methode [[[setCurrentStateAsReferenceState()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test06")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T5 = Criterion.builder()
        .shortDescription("Methode [[[getDiffX()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test04")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();
    public static final Criterion H2_2_T6 = Criterion.builder()
        .shortDescription("Methode [[[getDiffY()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test03")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T7 = Criterion.builder()
        .shortDescription("Methode [[[getDiffNumberOfCoins()]]] ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test08")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T8 = Criterion.builder()
        .shortDescription("Methode [[[getDiffDirection()]]] ist vollständig korrekt.")
        .maxPoints(2)
        .minPoints(0)
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_2.class.getMethod("test07")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2 = Criterion.builder()
        .shortDescription("H2.2 | Implementierende Roboterklasse mit vier [[[int]]]-Attributen für den Referenzstatus")
        .addChildCriteria(H2_2_T1, H2_2_T2, H2_2_T3, H2_2_T4, H2_2_T5, H2_2_T6, H2_2_T7, H2_2_T8)
        .build();


    ////////////////////////////////////////////////// H2.3

    public static final Criterion H2_3_T1 = Criterion.builder()
        .shortDescription("Klasse [[[RobotWithCoinTypesAndRefStateOne]]] ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_3_T2 = Criterion.builder()
        .shortDescription("Die Attribute [[[%s]]], [[[%s]]], [[[%s]]] und [[[%s]]] sind korrekt deklariert.".formatted(
            "refX", "refY", "refDirection", "refNumberOfCoins"))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test05")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_3_T3 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_3_T4 = Criterion.builder()
        .shortDescription("Die Methoden [[[%s]]], [[[%s]]], [[[%s]]], [[[%s]]] und [[[%s]]] sind vollständig korrekt.".formatted(
            "setCurrentStateAsReferenceState()", "getDiffX()", "getDiffY()", "getDiffDirection()", "getDiffNumberOfCoins()"))
        .minPoints(0)
        .maxPoints(2)
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test06")),
                JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test04")),
                JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test03")),
                JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test07")),
                JUnitTestRef.ofMethod(() -> H2_3.class.getMethod("test08"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_3 = Criterion.builder()
        .shortDescription("H2.3 | Implementierende Roboterklasse mit [[[Robot]]]-Objekt für den Referenzstatus")
        .addChildCriteria(H2_3_T1, H2_3_T2, H2_3_T3, H2_3_T4)
        .build();

    ////////////////////////////////////////////////// H2.4

    public static final Criterion H2_4_T1 = Criterion.builder()
        .shortDescription("Klasse [[[CoinCollection]]] ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T2 = Criterion.builder()
        .shortDescription("Die Attribute [[[%s]]], [[[%s]]] und [[[%s]]] sind korrekt deklariert.".formatted(
            "numberOfSilverCoins", "numberOfBrassCoins", "numberOfCopperCoins"))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test04")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();
    public static final Criterion H2_4_T3 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T4 = Criterion.builder()
        .shortDescription("Die Methoden [[[getNumberOfCoinsOfType()]]] und [[[setNumberOfCoinsOfType()]]] sind vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test07")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test08"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T5 = Criterion.builder()
        .shortDescription("Die Methoden [[[%s]]], [[[%s]]] und [[[%s]]] sind vollständig korrekt.".formatted(
            "getNumberOfSilverCoins()", "getNumberOfBrassCoins()", "getNumberOfCopperCoins()"))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test03")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test05")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test06"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T6 = Criterion.builder()
        .shortDescription("Die Methoden [[[insertCoin()]]] und [[[removeCoin()]]] sind vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test09")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test10"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4 = Criterion.builder()
        .shortDescription("H2.4 | Klasse ohne Roboter, aber mit Münztypen")
        .addChildCriteria(H2_4_T1, H2_4_T2, H2_4_T3, H2_4_T4, H2_4_T5, H2_4_T6)
        .build();

    ////////////////////////////////////////////////// Tasks

    public static final Criterion H1 = Criterion.builder()
        .shortDescription("H1 | Zwei Interfaces")
        .addChildCriteria(H1_1, H1_2)
        .build();
    public static final Criterion H2 = Criterion.builder()
        .shortDescription("H2 | Implementierende Klassen")
        .addChildCriteria(H2_1, H2_2, H2_3, H2_4)
        .build();

    static {
        try {
            Class.forName("org.sourcegrade.docwatcher.DocWatcherModule");
        } catch (ClassNotFoundException e) {
            // ignore
        }
    }

    @Override
    public Rubric getRubric() {
        return Rubric.builder()
            .title("H04 | Roboter mit Referenzstatus")
            .addChildCriteria(H1, H2)
            .build();
    }
}
