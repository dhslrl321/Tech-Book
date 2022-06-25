package org.example.song;

import java.util.function.Function;

public class ParsePolicy {
    ParseCondition condition;
    String result;

    public ParsePolicy(ParseCondition condition, String what) {
        this.condition = condition;
        this.result = what;
    }

    boolean isSatisfiedBy(String string) {
        return condition.isSatisfiedBy(string);
    }

    public String getResult() {
        return result;
    }
}
