package org.example.Pattern.abstractFactory.banking;

import org.example.Pattern.abstractFactory.ProjectManager;

public class PM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("bank manager working");
    }
}
