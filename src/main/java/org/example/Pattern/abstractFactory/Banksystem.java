package org.example.Pattern.abstractFactory;

import org.example.Pattern.abstractFactory.banking.BankTeamFactory;

public class Banksystem {
    public static void main(String[] args) {

        ProjectTeamFactory projectTeamFactory = new BankTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getManager();

        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();

    }


}
