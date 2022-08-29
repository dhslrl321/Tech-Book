package com.wonit;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Value;

@Value(staticConstructor = "of")
public class Call {
    LocalDateTime from;
    LocalDateTime to;

    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
