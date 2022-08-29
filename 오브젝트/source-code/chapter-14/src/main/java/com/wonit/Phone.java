package com.wonit;

import java.util.ArrayList;
import java.util.List;

public class Phone {

    private final List<Call> calls = new ArrayList<>();

    public void call(Call call) {
        calls.add(call);
    }

    public int numberOfCalls() {
        return calls.size();
    }
}
