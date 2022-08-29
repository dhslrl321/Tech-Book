package com.wonit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class PhoneTest {

    public static final LocalDateTime NOW = LocalDateTime.now();
    Phone sut = new Phone();

    @Test
    void name2() {
        Call call = Call.of(NOW.minusDays(2L), NOW);
        Call call2 = Call.of(NOW.minusDays(1L), NOW);

        sut.call(call);
        sut.call(call2);

        assertThat(sut.numberOfCalls()).isEqualTo(2);
    }
}