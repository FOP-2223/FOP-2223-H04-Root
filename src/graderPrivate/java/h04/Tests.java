package h04;

import org.tudalgo.algoutils.reflect.TestUtils;
import org.tudalgo.algoutils.tutor.general.match.BasicStringMatchers;
import org.tudalgo.algoutils.tutor.general.match.Match;
import org.tudalgo.algoutils.tutor.general.match.Matcher;
import org.tudalgo.algoutils.tutor.general.match.MatcherFactories.StringMatcherFactory;
import org.tudalgo.algoutils.tutor.general.match.Stringifiable;

public class Tests {

    private static final double MINIMUM_SIMILARITY = .8;

    private static final StringMatcherFactory STRING_MATCHER_FACTORY = BasicStringMatchers::identical;

    public static <T extends Stringifiable> Matcher<T> stringMatcher(String string) {

        return new Matcher<T>() {

            @Override
            public <ST extends T> Match<ST> match(ST object) {
                return new Match<>() {

                    final double similarity = TestUtils.similarity(object.string(), string);

                    @Override
                    public boolean matched() {
                        return similarity >= MINIMUM_SIMILARITY;
                    }

                    @Override
                    public ST object() {
                        return object;
                    }

                    @Override
                    public int compareTo(Match<ST> other) {
                        if (!other.matched()) {
                            return matched() ? 1 : 0;
                        } else if (!matched()) {
                            return -1;
                        }
                        double otherSimilarity = TestUtils.similarity(other.object().string(), string);
                        return Double.compare(similarity, otherSimilarity);
                    }
                };
            }
        };
    }
}




