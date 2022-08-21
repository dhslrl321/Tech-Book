import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
