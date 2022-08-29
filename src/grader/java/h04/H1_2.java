package h04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.reflect.ClassTester;
import org.tudalgo.algoutils.reflect.MethodTester;
import org.tudalgo.algoutils.reflect.ParameterMatcher;
import org.tudalgo.algoutils.reflect.TestUtils;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


@TestForSubmission("h04")
@DisplayName("H1_2")
public class H1_2 {
    public final static double minSim = 0.8d;
    public final static ClassTester<?> WithCoinTypesCT = new ClassTester<>("h04",
        "WithCoinTypes", minSim, Modifier.PUBLIC | Modifier.ABSTRACT | Modifier.INTERFACE);
    public final static ClassTester<?> CoinTypeCT = new ClassTester<>("h04",
        "CoinType", minSim,  Modifier.PUBLIC | Modifier.FINAL | TestUtils.ENUM);
    final String interface_name = "WithCoinTypes";
    final String enum_name = "CoinType";

    @Test
    @DisplayName("1 | Existenz Interface " + interface_name)
    public void test01() {
        WithCoinTypesCT.verify(1.0d);
    }

    @Test
    @DisplayName("2 | Existenz Enum " + enum_name)
    public void test02() {
        CoinTypeCT.verify(1.0d).assertEnumConstants(new String[]{"SILVER", "BRASS", "COPPER"});
    }

    @Test
    @DisplayName("3 | getNumberOfCoinsOfType()")
    public void test03() {
        new MethodTester(WithCoinTypesCT.assureClassResolved(),
            "getNumberOfCoinsOfType", 0.8,
            Modifier.PUBLIC | Modifier.ABSTRACT,
            int.class,
            new ArrayList<>(List.of(new ParameterMatcher("coinType", 0.8, CoinType.class)
            ))).verify();
    }

    @Test
    @DisplayName("4 | setNumberOfCoinsOfType()")
    public void test04() {
        new MethodTester(WithCoinTypesCT.assureClassResolved(),
            "setNumberOfCoinsOfType", 0.8,
            Modifier.PUBLIC | Modifier.ABSTRACT,
            void.class, new ArrayList<>(List.of(new ParameterMatcher("coinType", 0.8, CoinType.class)
            , new ParameterMatcher("number", 0.8, int.class)))).verify();
        ;
    }
}
