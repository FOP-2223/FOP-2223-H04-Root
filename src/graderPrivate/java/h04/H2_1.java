package h04;

import fopbot.World;
import h04.student.RobotWithCoinTypesData;
import h04.student.RobotWithCoinTypesStudent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.json.JsonClasspathSource;
import org.junitpioneer.jupiter.json.Property;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.reflections.FieldLink;

import java.util.List;

import static h04.student.CoinTypeStudent.linkToCoinTypeBrass;
import static h04.student.CoinTypeStudent.linkToCoinTypeCopper;
import static h04.student.CoinTypeStudent.linkToCoinTypeSilver;
import static h04.student.More.linkToInt;
import static h04.student.RobotStudent.linkToPickCoin;
import static h04.student.RobotStudent.linkToPutCoin;
import static h04.student.RobotStudent.linkToRobot;
import static h04.student.RobotStudent.linkToSetNumberOfCoins;
import static h04.student.RobotWithCoinTypesStudent.linkToNumberOfBrassCoins;
import static h04.student.RobotWithCoinTypesStudent.linkToNumberOfCopperCoins;
import static h04.student.RobotWithCoinTypesStudent.linkToNumberOfSilverCoins;
import static h04.student.RobotWithCoinTypesStudent.linkToRobotWithCoinTypes;
import static h04.student.RobotWithCoinTypesStudent.linkToRobotWithCoinTypesConstructor;
import static h04.student.WithCoinTypesStudent.linkToGetNumberOfCoinsOfType;
import static h04.student.WithCoinTypesStudent.linkToSetNumberOfCoinsOfType;
import static h04.student.WithCoinTypesStudent.linkToWithCoinTypes;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.assertEquals;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectInterfaces;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectStaticType;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectSuperType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PRIVATE;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;


@TestForSubmission
@DisplayName("H2_1")
public class H2_1 {

    @BeforeEach
    public void setupWorld() {
        World.setDelay(0);
        World.setSize(5, 5);
    }

    @Test
    @DisplayName("1 | Existenz Klasse RobotWithCoinTypes")
    public void t4() {
        var type = linkToRobotWithCoinTypes();
        assertCorrectModifiers(type, PUBLIC);
        assertCorrectSuperType(type, sameType(linkToRobot()));
        assertCorrectInterfaces(type, sameType(linkToWithCoinTypes()));
    }

    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_1.json")
    @DisplayName("2 | Konstruktor")
    public void t6(@Property("robot") RobotWithCoinTypesData robotData) {
        setupWorld();
        var robot = new RobotWithCoinTypesStudent(robotData, false);
        assertCorrectModifiers(linkToRobotWithCoinTypesConstructor(), PUBLIC);
        assertEquals(
            robotData.x(),
            robot.x(),
            robot.context(),
            r -> "unexpected x-coordinate"
        );
        assertEquals(
            robotData.y(),
            robot.y(),
            robot.context(),
            r -> "unexpected y-coordinate"
        );
        assertEquals(
            robotData.direction(),
            robot.direction(),
            robot.context(),
            r -> "unexpected direction"
        );
        assertEquals(
            robotData.numberOfSilverCoins(),
            robot.numberOfSilverCoins(),
            robot.context(),
            r -> "unexpected number of silver coins"
        );
        assertEquals(
            robotData.numberOfBrassCoins(),
            robot.numberOfBrassCoins(),
            robot.context(),
            r -> "unexpected number of brass coins"
        );
        assertEquals(
            robotData.numberOfCopperCoins(),
            robot.numberOfCopperCoins(),
            robot.context(),
            r -> "unexpected number of copper coins"
        );
    }

    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_1.json")
    @DisplayName("3 | getNumberOfCoinsOfType(CoinType)")
    public void t8(@Property("robot") RobotWithCoinTypesData robotData) {
        var method = linkToGetNumberOfCoinsOfType();
        var robot = new RobotWithCoinTypesStudent(robotData, true);
        var context = contextBuilder().subject(method).add(robot.context()).build();
        assertEquals(
            robotData.numberOfSilverCoins(),
            robot.getNumberOfCoinsOfType(linkToCoinTypeSilver().constant()),
            context,
            r -> "unexpected number of silver coins"
        );
        assertEquals(
            robotData.numberOfBrassCoins(),
            robot.getNumberOfCoinsOfType(linkToCoinTypeBrass().constant()),
            context,
            r -> "unexpected number of brass coins"
        );
        assertEquals(
            robotData.numberOfCopperCoins(),
            robot.getNumberOfCoinsOfType(linkToCoinTypeCopper().constant()),
            context,
            r -> "unexpected number of copper coins"
        );
    }

    //
    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_2.json")
    @DisplayName("4 | setNumberOfCoinsOfType(CoinType, int)")
    public void t9(
        @Property("robotBefore") RobotWithCoinTypesData robotBeforeData,
        @Property("robotAfter") RobotWithCoinTypesData robotAfterData
    ) {
        var robot = new RobotWithCoinTypesStudent(robotBeforeData, true);
        var context = contextBuilder()
            .subject(linkToSetNumberOfCoinsOfType())
            .add("numberOfSilverCoins", robotBeforeData.numberOfSilverCoins())
            .build();
        robot.setNumberOfCoinsOfType(linkToCoinTypeSilver().constant(), robotAfterData.numberOfSilverCoins());
        assertEquals(
            robotAfterData.numberOfSilverCoins(),
            robot.numberOfSilverCoins(),
            context,
            r -> "unexpected number of silver coins"
        );
        context = contextBuilder()
            .subject(linkToSetNumberOfCoinsOfType())
            .add("numberOfBrassCoins", robotBeforeData.numberOfBrassCoins())
            .build();
        robot.setNumberOfCoinsOfType(linkToCoinTypeBrass().constant(), robotAfterData.numberOfBrassCoins());
        assertEquals(
            robotAfterData.numberOfBrassCoins(),
            robot.numberOfBrassCoins(),
            context,
            r -> "unexpected number of brass coins"
        );
        context = contextBuilder()
            .subject(linkToSetNumberOfCoinsOfType())
            .add("numberOfCopperCoins", robotBeforeData.numberOfCopperCoins())
            .build();
        robot.setNumberOfCoinsOfType(linkToCoinTypeCopper().constant(), robotAfterData.numberOfCopperCoins());
        assertEquals(
            robotAfterData.numberOfCopperCoins(),
            robot.numberOfCopperCoins(),
            context,
            r -> "unexpected number of copper coins"
        );
        // check total number of coins
        context = contextBuilder()
            .subject(linkToSetNumberOfCoinsOfType())
            .add("numberOfSilverCoins", robotBeforeData.numberOfSilverCoins())
            .add("numberOfBrassCoins", robotBeforeData.numberOfBrassCoins())
            .add("numberOfCopperCoins", robotBeforeData.numberOfCopperCoins())
            .build();
        assertEquals(
            robotAfterData.numberOfSilverCoins() + robotAfterData.numberOfBrassCoins() + robotAfterData.numberOfCopperCoins(),
            robot.numberOfCoins(),
            context,
            r -> "unexpected total number of coins"
        );
    }

    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_3.json")
    @DisplayName("4 | setNumberOfCoinsOfType(CoinType, int) | IllegalArgumentException")
    public void t9_2(
        @Property("robotBefore") RobotWithCoinTypesData robotBeforeData,
        @Property("robotAfter") RobotWithCoinTypesData robotAfterData
    ) {
        var robot = new RobotWithCoinTypesStudent(robotBeforeData, true);
        robot.setNumberOfCoinsOfTypeExceptional(linkToCoinTypeSilver().constant(), robotAfterData.numberOfSilverCoins());
        robot.setNumberOfCoinsOfTypeExceptional(linkToCoinTypeBrass().constant(), robotAfterData.numberOfBrassCoins());
        robot.setNumberOfCoinsOfTypeExceptional(linkToCoinTypeCopper().constant(), robotAfterData.numberOfCopperCoins());
        assertEquals(
            robotBeforeData.numberOfSilverCoins(),
            robot.numberOfSilverCoins(),
            contextBuilder()
                .subject(linkToSetNumberOfCoinsOfType())
                .add("numberOfSilverCoinsBefore", robotBeforeData.numberOfSilverCoins())
                .add("numberOfSilverCoinsAfter", robotAfterData.numberOfSilverCoins())
                .build(),
            r -> "unexpected number of silver coins"
        );
        assertEquals(
            robotBeforeData.numberOfBrassCoins(),
            robot.numberOfBrassCoins(),
            contextBuilder()
                .subject(linkToSetNumberOfCoinsOfType())
                .add("numberOfBrassCoinsBefore", robotBeforeData.numberOfBrassCoins())
                .add("numberOfBrassCoinsAfter", robotAfterData.numberOfBrassCoins())
                .build(),
            r -> "unexpected number of brass coins"
        );
        assertEquals(
            robotBeforeData.numberOfCopperCoins(),
            robot.numberOfCopperCoins(),
            contextBuilder()
                .subject(linkToSetNumberOfCoinsOfType())
                .add("numberOfCopperCoinsBefore", robotBeforeData.numberOfCopperCoins())
                .add("numberOfCopperCoinsAfter", robotAfterData.numberOfCopperCoins())
                .build(),
            r -> "unexpected number of copper coins"
        );
    }

    @Test
    @DisplayName("5 | Attribute numberOfSilverCoins, numberOfBrassCoins, numberOfCopperCoins")
    public void t5() {
        for (FieldLink link : List.of(linkToNumberOfSilverCoins(), linkToNumberOfBrassCoins(), linkToNumberOfCopperCoins())) {
            assertCorrectStaticType(link, sameType(linkToInt()));
            assertCorrectModifiers(link, PRIVATE);
        }
    }


    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_1.json")
    @DisplayName("6 | setNumberOfCoins(int)")
    public void t7(
        @Property("robot") RobotWithCoinTypesData robotData,
        @Property("numberOfCoins") int numberOfCoins
    ) {
        var robot = new RobotWithCoinTypesStudent(robotData, true);
        robot.setNumberOfCoins(numberOfCoins);
        var context = contextBuilder()
            .subject(linkToSetNumberOfCoins())
            .add("initial", context(robotData))
            .add("numberOfCoins", numberOfCoins)
            .build();
        assertEquals(
            robotData.numberOfSilverCoins(),
            robot.numberOfSilverCoins(),
            context,
            r -> "unexpected number of silver coins"
        );
        assertEquals(
            robotData.numberOfBrassCoins(),
            robot.numberOfBrassCoins(),
            context,
            r -> "unexpected number of brass coins"
        );
        assertEquals(
            numberOfCoins,
            robot.numberOfCopperCoins(),
            context,
            r -> "unexpected number of copper coins"
        );
    }

    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_1.json")
    @DisplayName("7 | pickCoin()")
    public void t11(
        @Property("robot") RobotWithCoinTypesData robotData
    ) {
        World.getGlobalWorld().putCoins(robotData.x(), robotData.y(), 10);
        var instance = new RobotWithCoinTypesStudent(robotData, true);
        instance.pickCoin();
        var context = contextBuilder()
            .subject(linkToPickCoin())
            .add("initial", context(robotData))
            .build();
        Assertions2.assertEquals(
            robotData.numberOfCopperCoins() + 1,
            instance.numberOfCopperCoins(),
            context,
            r -> "unexpected number of copper coins"
        );
        assertEquals(
            robotData.numberOfSilverCoins(),
            instance.numberOfSilverCoins(),
            context,
            r -> "unexpected number of silver coins"
        );
        assertEquals(
            robotData.numberOfBrassCoins(),
            instance.numberOfBrassCoins(),
            context,
            r -> "unexpected number of brass coins"
        );
    }

    @SuppressWarnings("DuplicatedCode")
    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_2.json")
    @DisplayName("8 | putCoin()")
    public void t10(
        @Property("robotBefore") RobotWithCoinTypesData robotBeforeData,
        @Property("robotAfter") RobotWithCoinTypesData robotAfterData
    ) {
        var robot = new RobotWithCoinTypesStudent(robotBeforeData, true);
        robot.putCoin();
        var context = contextBuilder()
            .subject(linkToPutCoin())
            .add("before", context(robotBeforeData))
            .build();
        Assertions2.assertEquals(
            robotAfterData.numberOfCopperCoins(),
            robot.numberOfCopperCoins(),
            context,
            r -> "unexpected number of copper coins"
        );
        assertEquals(
            robotAfterData.numberOfSilverCoins(),
            robot.numberOfSilverCoins(),
            context,
            r -> "unexpected number of silver coins"
        );
        assertEquals(
            robotAfterData.numberOfBrassCoins(),
            robot.numberOfBrassCoins(),
            context,
            r -> "unexpected number of brass coins"
        );
        assertEquals(
            robotAfterData.numberOfSilverCoins() + robotAfterData.numberOfBrassCoins() + robotAfterData.numberOfCopperCoins(),
            robot.numberOfCoins(),
            context,
            r -> "unexpected number of total coins"
        );
    }

    @SuppressWarnings("DuplicatedCode")
    @ParameterizedTest
    @JsonClasspathSource("h04/H2_1_4.json")
    @DisplayName("8 | putCoin()")
    public void t10_2(
        @Property("robot") RobotWithCoinTypesData robotData
    ) {
        var robot = new RobotWithCoinTypesStudent(robotData, true);
        robot.putCoinExceptional();
        var context = contextBuilder()
            .subject(linkToPutCoin())
            .add("before", context(robotData))
            .build();
        Assertions2.assertEquals(
            robotData.numberOfCopperCoins(),
            robot.numberOfCopperCoins(),
            context,
            r -> "unexpected number of copper coins"
        );
        assertEquals(
            robotData.numberOfSilverCoins(),
            robot.numberOfSilverCoins(),
            context,
            r -> "unexpected number of silver coins"
        );
        assertEquals(
            robotData.numberOfBrassCoins(),
            robot.numberOfBrassCoins(),
            context,
            r -> "unexpected number of brass coins"
        );
        assertEquals(
            robotData.numberOfSilverCoins() + robotData.numberOfBrassCoins() + robotData.numberOfCopperCoins(),
            robot.numberOfCoins(),
            context,
            r -> "unexpected number of total coins"
        );
    }
}

