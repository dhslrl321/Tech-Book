package org.example.song;

import java.util.ArrayList;
import java.util.List;

public class PolicyContainer {

    private final List<ParsePolicy> policies = new ArrayList<>();

    public PolicyContainer() {
        policies.add(new ParsePolicy(new ACondition(), "이것은 a 입니다."));
        policies.add(new ParsePolicy(new BCondition(), "이것은 b 입니다."));
        policies.add(new ParsePolicy(new CCondition(), "이것은 c 입니다."));
    }

    public ParsePolicy getBestPolicy(String string) {
        for (ParsePolicy policy : policies) {
            if (policy.isSatisfiedBy(string)) {
                return policy;
            }
        }
        return null;
    }

}
