package org.example.Pattern.builder;

public class buildRunner {
    public static void main(String[] args) {
        Builder builder = new Builder();

        builder.setAutoBuilder(new SmallCarBuilder());
        Auto auto = builder.buildAuto();

        System.out.println(auto);
    }

}
