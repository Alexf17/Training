package org.example.Pattern.builder;

public class BigAutoBuilder extends AutoBuilder{
    @Override
    void buildName() {
        auto.setName("Auto2");
    }

    @Override
    void buildModel() {
auto.setModel(String.valueOf(Model.MODEL2));
    }

    @Override
    void buildPrice() {
auto.setPrice(50000);
    }
}
