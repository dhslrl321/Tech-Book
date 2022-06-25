package org.example.song;

public class ACondition implements ParseCondition {

    @Override
    public boolean isSatisfiedBy(String string) {
        return "a".equals(string);
    }
}
