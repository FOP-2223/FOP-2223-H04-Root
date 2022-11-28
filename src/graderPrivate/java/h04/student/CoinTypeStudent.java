package h04.student;

import org.tudalgo.algoutils.tutor.general.assertions.Assertions3;
import org.tudalgo.algoutils.tutor.general.reflections.EnumConstantLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import static h04.Tests.stringMatcher;
import static h04.student.H01Student.linkToH01;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertTypeExists;
import static org.tudalgo.algoutils.tutor.general.match.BasicStringMatchers.identical;

public class CoinTypeStudent {

    public static TypeLink linkToCoinType() {
        return assertTypeExists(linkToH01(), stringMatcher("CoinType"));
    }

    public static EnumConstantLink linkToCoinTypeSilver() {
        return Assertions3.assertHasEnumConstant(linkToCoinType(), stringMatcher("SILVER"));
    }

    public static EnumConstantLink linkToCoinTypeBrass() {
        return Assertions3.assertHasEnumConstant(linkToCoinType(), stringMatcher("BRASS"));
    }

    public static EnumConstantLink linkToCoinTypeCopper() {
        return Assertions3.assertHasEnumConstant(linkToCoinType(), stringMatcher("COPPER"));
    }
}
