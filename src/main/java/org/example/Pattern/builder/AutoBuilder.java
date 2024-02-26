package org.example.Pattern.builder;

public abstract class AutoBuilder {
    Auto auto;
    void createAuto(){
        auto = new Auto();
    }
    abstract void buildName();
    abstract void buildModel();
    abstract  void buildPrice();

    Auto getAuto(){
        return auto;
    }

}
