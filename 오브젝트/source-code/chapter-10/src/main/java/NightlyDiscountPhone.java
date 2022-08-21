import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private double taxRate;
    private Money nightlyAmount;
    private final Money regularAmount;
    private final Duration seconds;
    private final List<Call> calls = new ArrayList<>();

    @Deprecated
    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getRegularAmount() {
        return regularAmount;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;
        for (Call call : calls) {
            long percent = call.getDuration().getSeconds() / seconds.getSeconds();
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(nightlyAmount.times(percent));
            } else {
                result = result.plus(regularAmount.times(percent));
            }

        }

        return result;
    }
}
