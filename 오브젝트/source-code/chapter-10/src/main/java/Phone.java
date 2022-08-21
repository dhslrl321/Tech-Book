import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private double taxRate;
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    @Deprecated
    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;
        for (Call call : calls) {
            long percent = call.getDuration().getSeconds() / seconds.getSeconds();
            result = result.plus(amount.times(percent));
        }

        return result.plus(result.times(taxRate));
    }
}
