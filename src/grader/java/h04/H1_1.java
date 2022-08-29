package h04;

import fopbot.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.reflect.ClassTester;
import org.tudalgo.algoutils.reflect.MethodTester;

import java.lang.reflect.Modifier;
import java.util.ArrayList;



@TestForSubmission("h04")
@DisplayName("H1_1")
public class H1_1 {
    public final static double minSim = 0.8d;
    public final static ClassTester<?> RobotWithReferenceStateCT = new ClassTester<>("h04",
        "RobotWithReferenceState", minSim, Modifier.PUBLIC | Modifier.ABSTRACT | Modifier.INTERFACE);
    final String interface_name = "RobotWithReferenceState";

    @Test
    @DisplayName("1 | Existenz Interface " + interface_name)
    public void test01() {
        RobotWithReferenceStateCT.verify(1.0d);
    }

    @Test
    @DisplayName("2 | setCurrentStateAsReferenceState()")
    public void test02() {
        new MethodTester(RobotWithReferenceStateCT.assureClassResolved(),
            "setCurrentStateAsReferenceState", 0.8,
            Modifier.PUBLIC | Modifier.ABSTRACT,
            void.class, new ArrayList<>()).verify();
    }

    @Test
    @DisplayName("3 | getDiffX()")
    public void test03() {
        new MethodTester(RobotWithReferenceStateCT.assureClassResolved(),
            "getDiffX", 0.8,
            Modifier.PUBLIC | Modifier.ABSTRACT,
            int.class, new ArrayList<>()).verify();
    }

    @Test
    @DisplayName("4 | getDiffY()")
    public void test04() {
        new MethodTester(RobotWithReferenceStateCT.assureClassResolved(),
            "getDiffY", 0.8,
            Modifier.PUBLIC | Modifier.ABSTRACT,
            int.class, new ArrayList<>()).verify();
    }

    @Test
    @DisplayName("5 | getDiffDirection()")
    public void test05() {
        new MethodTester(RobotWithReferenceStateCT.assureClassResolved(),
            "getDiffDirection", 0.8,
            Modifier.PUBLIC | Modifier.ABSTRACT,
            Direction.class, new ArrayList<>()).verify();
    }

    @Test
    @DisplayName("6 | getDiffNumberOfCoins()")
    public void test06() {
        new MethodTester(RobotWithReferenceStateCT.assureClassResolved(),
            "getDiffNumberOfCoins", 0.8,
            Modifier.PUBLIC | Modifier.ABSTRACT,
            int.class, new ArrayList<>()).verify();
    }
}
