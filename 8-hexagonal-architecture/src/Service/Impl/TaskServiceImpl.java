package Service.Impl;

import Service.TaskService;
import domain.Task;
import repository.TaskRepository;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createTask(String id, String description) {
        Task task = new Task(id, description);
        repository.save(task);
    }

    @Override
    public void completedTaks(String id) {
        Task task = repository.findById(id);
        task.maskAsCompleted();
        repository.save(task);

    }
}
