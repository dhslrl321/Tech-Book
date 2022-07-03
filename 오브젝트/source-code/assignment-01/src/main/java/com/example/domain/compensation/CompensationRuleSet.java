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
            updateActualCount(hits, rule);
        }
    }

    public Compensations toCompensations() {
        return Compensations.from(rules.stream()
                .map(CompensationRule::toCompensation)
                .collect(Collectors.toList()));
    }

    private void updateActualCount(List<Integer> hits, CompensationRule rule) {
        for (Integer hit : hits) {
            plusBestRule(rule, hit);
        }
    }

    private void plusBestRule(CompensationRule rule, Integer hit) {
        if (rule.isSatisfiedBy(hit)) {
            rule.plusActualCount();
        }
    }
}
