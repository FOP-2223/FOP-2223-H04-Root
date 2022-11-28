package h04.student;

import org.tudalgo.algoutils.tutor.general.assertions.Assertions3;
import org.tudalgo.algoutils.tutor.general.reflections.EnumConstantLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import static h04.Tests.stringMatcher;
import static h04.student.H01Student.linkToH01;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertTypeExists;

public class CoinTypeStudent {

    public static TypeLink linkToCoinType() {
        return assertTypeExists(linkToH01(), stringMatcher("CoinType"));
    }

    private static EnumConstantLink linkToCoinTypeSilver = null;
    private static EnumConstantLink linkToCoinTypeCopper = null;
    private static EnumConstantLink linkToCoinTypeBrass = null;

    public static EnumConstantLink linkToCoinTypeSilver() {
        if (linkToCoinTypeSilver != null) {
            return linkToCoinTypeSilver;
        }
        return linkToCoinTypeSilver = Assertions3.assertHasEnumConstant(linkToCoinType(), stringMatcher("SILVER"));
    }

    public static EnumConstantLink linkToCoinTypeBrass() {
        if (linkToCoinTypeCopper != null) {
            return linkToCoinTypeCopper;
        }
        return linkToCoinTypeCopper = Assertions3.assertHasEnumConstant(linkToCoinType(), stringMatcher("BRASS"));
    }

    public static EnumConstantLink linkToCoinTypeCopper() {
        if (linkToCoinTypeBrass != null) {
            return linkToCoinTypeBrass;
        }
        return linkToCoinTypeBrass = Assertions3.assertHasEnumConstant(linkToCoinType(), stringMatcher("COPPER"));
    }
}
