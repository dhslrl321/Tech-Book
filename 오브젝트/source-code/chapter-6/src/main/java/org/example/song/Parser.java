package org.example.song;

public class Parser {


    public static void main(String[] args) {

        String[] data = {"a", "b", "c", "d"};
        PolicyContainer container = new PolicyContainer();

        for (String datum : data) {
            ParsePolicy policy = container.getBestPolicy(datum);
            String result = policy.getResult();
            System.out.println("result = " + result);
        }

    }

}
