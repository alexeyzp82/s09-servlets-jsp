package com.softserve.itacademy.repository;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks;

    private TaskRepository() {
        tasks = new LinkedList<>();
        tasks.add(new Task("Task #1", Priority.MEDIUM));
        tasks.add(new Task("Task #2", Priority.LOW));
    }

    public boolean create(Task task) {
        boolean status = tasks.stream().anyMatch(t -> t.getTitle().equals(task.getTitle()));
        if (!status) {
            return tasks.add(task);
        }
        return false;
    }

    public Task read(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public boolean update(Task newTask) {
        Task oldTask = read(newTask.getId());
        if (oldTask != null) {
            boolean status = all().stream()
                    .filter(task -> task.getId() != oldTask.getId())
                    .anyMatch(task -> task.getTitle().equals(newTask.getTitle()));
            if (!status) {
                return tasks.set(tasks.indexOf(oldTask), newTask) != null;
            }
            return false;
        }
        return false;
    }

    public boolean delete(int id) {
        Task task = read(id);
        if (task != null) {
            return tasks.remove(task);
        }
        return false;
    }

    public List<Task> all() {
        return tasks;
    }

    public void deleteAll() {
        tasks.clear();
    }

    private static TaskRepository taskRepository = null;

    public synchronized static TaskRepository getTaskRepository() {
        if (taskRepository == null) {
            taskRepository = new TaskRepository();
        }
        return taskRepository;
    }
}
