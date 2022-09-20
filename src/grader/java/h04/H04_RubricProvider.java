package h04;

import org.sourcegrade.docwatcher.api.grading.DocumentationCriterion;
import org.sourcegrade.docwatcher.api.grading.DocumentationGrader;
import org.sourcegrade.jagr.api.rubric.*;
import org.tudalgo.algoutils.reflect.MethodTester;

import static h04.H1_1.RobotWithReferenceStateCT;
import static h04.H1_2.WithCoinTypesCT;
import static h04.H2_1.RobotWithCoinTypesCT;
import static h04.H2_2.RobotWithCoinTypesAndRefState1CT;
import static h04.H2_3.RobotWithCoinTypesAndRefState2CT;
import static h04.H2_4.CoinCollectionCT;

@RubricForSubmission("h04")
public class H04_RubricProvider implements RubricProvider {

    ///////////////////////////////////////////////// H1.1

    public static final Criterion H1_1_T1 = Criterion.builder()
        .shortDescription("Methoden setCurrentStateAsReferenceState(), getDiffX(), getDiffY(), getDiffDirection(), " +
            "getDiffNumberOfCoins() sind korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test02")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test03")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test04")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test05")),
                JUnitTestRef.ofMethod(() -> H1_1.class.getMethod("test06"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_1_T2 = Criterion.builder()
        .shortDescription("Interface RobotWithReferenceState ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H1_1.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_1 = Criterion.builder()
        .shortDescription("H1.1 Interface RobotWithReferenceState")
        .minPoints(0)
        .maxPoints(2)
        .addChildCriteria(
            H1_1_T1,
            H1_1_T2)
        .build();

    ///////////////////////////////////////////////// H1.2

    public static final Criterion H1_2_T1 = Criterion.builder()
        .shortDescription("Methoden getNumberOfCoinsOfType(), setNumberOfCoinsOfType() sind korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H1_2.class.getMethod("test03")),
                JUnitTestRef.ofMethod(() -> H1_2.class.getMethod("test04"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_2_T2 = Criterion.builder()
        .shortDescription("Enum CoinType ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H1_2.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_2_T3 = Criterion.builder()
        .shortDescription("Interface WithCoinTypes ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H1_2.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H1_2 = Criterion.builder()
        .shortDescription("H1.2 Interface WithCoinTypes")
        .minPoints(0)
        .maxPoints(3)
        .addChildCriteria(
            H1_2_T1,
            H1_2_T2,
            H1_2_T3)
        .build();

    ///////////////////////////////////////////////// H2.1

    public static final Criterion H2_1_T1 = Criterion.builder()
        .shortDescription("Methode setNumberOfCoins() ist vollständig korrekt.")
        .maxPoints(2)
        .minPoints(0)
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test06")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T2 = Criterion.builder()
        .shortDescription("Attribute numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins sind deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test05")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T3 = Criterion.builder()
        .shortDescription("Methode setNumberOfCoinsOfType() ist vollständig korrekt.")
        .maxPoints(2)
        .minPoints(0)
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test04")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();
    public static final Criterion H2_1_T4 = Criterion.builder()
        .shortDescription("Methode getNumberOfCoinsOfType() ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test03")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T5 = Criterion.builder()
        .shortDescription("Methode pickCoin() ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test07")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T6 = Criterion.builder()
        .shortDescription("Methode putCoin() ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test08")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T7 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1_T8 = Criterion.builder()
        .shortDescription("Klasse RobotWithCoinTypes ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_1.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_1 = Criterion.builder()
        .shortDescription("H2.1 Implementierende Roboterklasse mit verschiedenen Münztypen")
        .minPoints(0)
        .maxPoints(10)
        .addChildCriteria(
            H2_1_T1,
            H2_1_T2,
            H2_1_T3,
            H2_1_T4,
            H2_1_T5,
            H2_1_T6,
            H2_1_T7,
            H2_1_T8)
        .build();

    ///////////////////////////////////////////////// H2.2

    public static final Criterion H2_2_T1 = Criterion.builder()
        .shortDescription("Methode setCurrentStateAsReferenceState() ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test06")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T2 = Criterion.builder()
        .shortDescription("Attribute refX, refY, refDirection, refNumberOfCoins sind deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test05")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T3 = Criterion.builder()
        .shortDescription("Methode getDiffX() ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test04")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();
    public static final Criterion H2_2_T4 = Criterion.builder()
        .shortDescription("Methode getDiffY() ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test03")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T5 = Criterion.builder()
        .shortDescription("Methode getDiffDirection() ist vollständig korrekt.")
        .maxPoints(2)
        .minPoints(0)
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test07")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T6 = Criterion.builder()
        .shortDescription("Methode getDiffNumberOfCoins() ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test08")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T7 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2_T8 = Criterion.builder()
        .shortDescription("Klasse RobotWithCoinTypesAndRefStateTwo ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_2.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_2 = Criterion.builder()
        .shortDescription("H2.2 Implementierende Roboterklasse mit vier int-Attributen für den Referenzstatus")
        .minPoints(0)
        .maxPoints(9)
        .addChildCriteria(
            H2_2_T1,
            H2_2_T2,
            H2_2_T3,
            H2_2_T4,
            H2_2_T5,
            H2_2_T6,
            H2_2_T7,
            H2_2_T8)
        .build();


    ///////////////////////////////////////////////// H2.3

    public static final Criterion H2_3_T1 = Criterion.builder()
        .shortDescription("Methoden setCurrentStateAsReferenceState(), getDiffX(), getDiffY() " +
            "getDiffDirection(), getDiffNumberOfCoins() sind vollständig korrekt.")
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

    public static final Criterion H2_3_T2 = Criterion.builder()
        .shortDescription("Attribute refX, refY, refDirection, refNumberOfCoins sind deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_3.class.getMethod("test05")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_3_T3 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_3.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_3_T4 = Criterion.builder()
        .shortDescription("Klasse RobotWithCoinTypesAndRefStateOne ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_3.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_3 = Criterion.builder()
        .shortDescription("H2.3 Implementierende Roboterklasse mit Robot-Objekt für den Referenzstatus")
        .minPoints(0)
        .maxPoints(5)
        .addChildCriteria(
            H2_3_T1,
            H2_3_T2,
            H2_3_T3,
            H2_3_T4)
        .build();

    ///////////////////////////////////////////////// H2.4

    public static final Criterion H2_4_T1 = Criterion.builder()
        .shortDescription("Methoden getNumberOfSilverCoins(), getNumberOfBrassCoins(), getNumberOfCopperCoins() " +
            "sind vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test03")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test05")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test06"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T2 = Criterion.builder()
        .shortDescription("Attribute numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins sind deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_4.class.getMethod("test04")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T3 = Criterion.builder()
        .shortDescription("Methoden getNumberOfCoinsOfType(), setNumberOfCoinsOfType() sind vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test07")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test08"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T4 = Criterion.builder()
        .shortDescription("Methoden insertCoin(), removeCoin() sind vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.and(
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test09")),
                JUnitTestRef.ofMethod(() -> H2_4.class.getMethod("test10"))))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();
    public static final Criterion H2_4_T5 = Criterion.builder()
        .shortDescription("Der Konstruktor ist vollständig korrekt.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_4.class.getMethod("test02")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4_T6 = Criterion.builder()
        .shortDescription("Klasse CoinCollection ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef
                .ofMethod(() -> H2_4.class.getMethod("test01")))
            .pointsPassedMax()
            .pointsFailedMin()
            .build())
        .build();

    public static final Criterion H2_4 = Criterion.builder()
        .shortDescription("H2.4 Klasse ohne Roboter, aber mit Münztypen")
        .minPoints(0)
        .maxPoints(6)
        .addChildCriteria(
            H2_4_T1,
            H2_4_T2,
            H2_4_T3,
            H2_4_T4,
            H2_4_T5,
            H2_4_T6)
        .build();

    ///////////////////////////////////////////////// Tasks
    public static final Criterion H1 = Criterion.builder()
        .shortDescription("H1 Zwei Interfaces")
        .addChildCriteria(
            H1_1,
            H1_2)
        .build();
    public static final Criterion H2 = Criterion.builder()
        .shortDescription("H2 Implementierende Klassen")
        .addChildCriteria(
            H2_1,
            H2_2,
            H2_3,
            H2_4)
        .build();

    public static final Criterion JAVADOC;


    static {
        try {
            Class.forName("org.sourcegrade.docwatcher.DocWatcherModule");
        } catch (ClassNotFoundException e) {
            // ignore
        }
        JAVADOC = DocumentationCriterion.forGrader(
            DocumentationGrader.builder()
                .addJavaDoc(new MethodTester(RobotWithReferenceStateCT, "setCurrentStateAsReferenceState")::getMethodDocumentation, H1_1)
                .addJavaDoc(new MethodTester(RobotWithReferenceStateCT, "getDiffX")::getMethodDocumentation, H1_1)
                .addJavaDoc(new MethodTester(RobotWithReferenceStateCT, "getDiffY")::getMethodDocumentation, H1_1)
                .addJavaDoc(new MethodTester(RobotWithReferenceStateCT, "getDiffDirection")::getMethodDocumentation, H1_1)
                .addJavaDoc(new MethodTester(RobotWithReferenceStateCT, "getDiffNumberOfCoins")::getMethodDocumentation, H1_1)
                .addJavaDoc(new MethodTester(WithCoinTypesCT, "getNumberOfCoinsOfType")::getMethodDocumentation, H1_2)
                .addJavaDoc(new MethodTester(WithCoinTypesCT, "setNumberOfCoinsOfType")::getMethodDocumentation, H1_2)
                .addJavaDoc(RobotWithCoinTypesCT::getConstructorDocumentation, H2_1)
                .addJavaDoc(RobotWithCoinTypesAndRefState1CT::getConstructorDocumentation, H2_2)
                .addJavaDoc(RobotWithCoinTypesAndRefState2CT::getConstructorDocumentation, H2_3)
                .addJavaDoc(CoinCollectionCT::getConstructorDocumentation, H2_4)
                .addJavaDoc(new MethodTester(CoinCollectionCT, "getNumberOfSilverCoins")::getMethodDocumentation, H2_4)
                .addJavaDoc(new MethodTester(CoinCollectionCT, "getNumberOfBrassCoins")::getMethodDocumentation, H2_4)
                .addJavaDoc(new MethodTester(CoinCollectionCT, "getNumberOfCopperCoins")::getMethodDocumentation, H2_4)
                .build());
    }


    public static final Rubric RUBRIC = Rubric.builder()
        .title("H04")
        .addChildCriteria(H1, H2, JAVADOC)
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
