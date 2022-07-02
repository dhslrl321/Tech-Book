package com.example.domain.compensation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompensationRuleSet {

    private final List<CompensationRule> rules = new ArrayList<>();

    public static CompensationRuleSet empty() {
        return new CompensationRuleSet();
    }

    public int getRuleSize() {
        return rules.size();
    }

    public void addRule(CompensationRule rule) {
        rules.add(rule);
    }

    public void counting(List<Integer> hits) {
        for (CompensationRule rule : rules) {
            for (Integer hit : hits) {
                if (rule.isSatisfiedBy(hit)) {
                    rule.plusActualCount();
                }
            }
        }
    }

    public List<Compensation> toCompensations() {
        return rules.stream()
                .map(CompensationRule::toCompensation)
                .collect(Collectors.toList());
    }
}
