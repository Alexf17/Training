package org.example.Pattern.abstractFactory.site;

import org.example.Pattern.abstractFactory.ProjectManager;

public class websitePm implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("pm work");
    }
}
