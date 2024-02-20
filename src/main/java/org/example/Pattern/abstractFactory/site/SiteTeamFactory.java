package org.example.Pattern.abstractFactory.site;

import org.example.Pattern.abstractFactory.Developer;
import org.example.Pattern.abstractFactory.ProjectManager;
import org.example.Pattern.abstractFactory.ProjectTeamFactory;
import org.example.Pattern.abstractFactory.Tester;

public class SiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDevel();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getManager() {
        return new websitePm();
    }
}
