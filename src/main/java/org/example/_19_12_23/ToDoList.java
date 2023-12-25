package org.example._19_12_23;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private List<ToDo> tasks = new ArrayList<ToDo>();

    public void addTask(ToDo task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    public void removeCompletedTask() {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isCompleted()) {
                tasks.remove(i);
            }
        }
    }

    public List<ToDo> getOpenedTasks() {
        List<ToDo> openedTasks = new ArrayList<>();
        for (ToDo task : tasks) {
            if (!task.isCompleted()) {
                openedTasks.add(task);
            }
        }
        return openedTasks;
    }

}
