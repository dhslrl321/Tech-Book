package org.example;

public class Money {

    private final long value;
    private Origin from;

    private Money(long value) {
        this.value = value;
    }

    public static Money of(long value) {
        return new Money(value);
    }

    public Money plus(Money target) {
        return new Money(value + target.value);
    }

    public Money minus(Money target) {
        return new Money(value - target.value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
/**
 * 가난아미ㅏㄴㄴ아ㅟ문아ㅜㅏㅣㅈ미ㅏ눙우ㅏㅣㅁ니ㅏㅁㄴ우ㅏㅁ누아ㅣㅁ눙미;자라ㅜㄴㅁㅇㄹ;ㅣㅜㅏㄴㅁㄹ이ㅏㅜㄹ이앙ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ우ㅏ미누아ㅣ무';ㅁㄷㅈㄴ룬우ㅏㅣ;ㅜㅍㅊㅌ;ㅣㅏㅜㄹㅁㄴ이ㅏ룸ㄴㅇ라ㅣㅁㄴㅇ리ㅏㄷㄱㅁㅈㄷ;ㅣㅏㅇㄴ;ㅐㅣㅏㅁ;ㅣㅁㄴㅇ;ㅣㅏㅏㅣㅣㅏ;까가나아눙낭
 * 절대 안살걸요 ㅋㅋㅋㅋ 반발력이 최고져 이게 너무 뭔가 키보드가
* 이게 제일 ㅈ같은게 무엇이냐면요?
 * 커맨드 키가 스페이스와 너무 붙어있어요
 */