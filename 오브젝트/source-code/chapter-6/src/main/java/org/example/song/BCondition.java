package org.example.song;

public class BCondition implements ParseCondition {
    @Override
    public boolean isSatisfiedBy(String string) {
        return "b".equals(string);
    }
}
