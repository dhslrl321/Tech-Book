import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class PhoneTest {

    public static final LocalDateTime _2018_01_01_12_10_0 = LocalDateTime.of(2018, 1, 1, 12, 10, 0);
    public static final LocalDateTime _2018_01_01_12_11_0 = LocalDateTime.of(2018, 1, 1, 12, 11, 0);

    @Test
    void name() {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));

        phone.call(new Call(_2018_01_01_12_10_0, _2018_01_01_12_11_0));
        phone.call(new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
                LocalDateTime.of(2018, 1, 2, 12, 11, 0)));

        Money actual = phone.calculateFee();

        assertThat(actual.getAmount()).isEqualTo(60);
    }
}