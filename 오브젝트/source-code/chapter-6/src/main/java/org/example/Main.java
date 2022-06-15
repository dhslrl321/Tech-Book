package org.example;

public class Main {
    public static void main(String[] args) {

        Money base = Money.of(123L);
        Money money1 = Money.of(123L);
        Money money2 = Money.of(123L);
        Money money3 = Money.of(123L);

        Money total = base.plus(money1).plus(money2).plus(money3);

        System.out.println("total = " + total);
    }
}
