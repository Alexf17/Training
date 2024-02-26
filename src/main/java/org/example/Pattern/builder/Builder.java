package org.example.Pattern.builder;

public class Builder {
    AutoBuilder autoBuilder;
    public void setAutoBuilder(AutoBuilder autoBuilder){
        this.autoBuilder = autoBuilder;
    }
    Auto buildAuto(){
        autoBuilder.createAuto();
        autoBuilder.buildName();
        autoBuilder.buildModel();
        autoBuilder.buildPrice();

        Auto auto = autoBuilder.getAuto();
        return auto;
    }
}
