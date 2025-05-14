package repository.impl;

import domain.Task;
import repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;

public class TaskRepositoryImpl implements TaskRepository {
    private final Map<String, Task> storage = new HashMap<>();

    @Override
    public void save(Task task) {
        storage.put(task.getId(), task);
    }

    @Override
    public Task findById(String id) {
        return storage.get(id);
    }
}
