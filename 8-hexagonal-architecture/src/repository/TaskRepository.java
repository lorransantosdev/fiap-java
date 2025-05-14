package repository;

import Service.TaskService;
import domain.Task;

public interface TaskRepository {

    void save(Task task);
    Task findById(String id);
}
