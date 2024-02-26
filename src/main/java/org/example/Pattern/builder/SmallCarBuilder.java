package org.example.Pattern.builder;

public class SmallCarBuilder extends AutoBuilder{
    @Override
    void buildName() {
        auto.setName("Auto1");
    }

    @Override
    void buildModel() {
auto.setModel(String.valueOf(Model.MODEL1));
    }

    @Override
    void buildPrice() {
auto.setPrice(10000);
    }
}
