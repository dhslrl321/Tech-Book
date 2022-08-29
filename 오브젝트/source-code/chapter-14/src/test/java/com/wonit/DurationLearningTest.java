package com.wonit;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class DurationLearningTest {
    @Test
    void name() {
        Duration actual = Duration.between(LocalDateTime.now().minusDays(1L), LocalDateTime.now());
    }
}
