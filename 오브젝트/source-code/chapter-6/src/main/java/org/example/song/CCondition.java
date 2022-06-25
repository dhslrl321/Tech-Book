package org.example.song;

public class CCondition implements ParseCondition {
    @Override
    public boolean isSatisfiedBy(String string) {
        return "c".equals(string);
    }
}
