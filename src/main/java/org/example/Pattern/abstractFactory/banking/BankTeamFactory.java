package org.example.Pattern.abstractFactory.banking;

import org.example.Pattern.abstractFactory.Developer;
import org.example.Pattern.abstractFactory.ProjectManager;
import org.example.Pattern.abstractFactory.ProjectTeamFactory;
import org.example.Pattern.abstractFactory.Tester;

public class BankTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QA();
    }

    @Override
    public ProjectManager getManager() {
        return new PM();
    }
}
