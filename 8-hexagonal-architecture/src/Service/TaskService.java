package Service;

public interface TaskService {

    void createTask(String id, String description);
    void completedTaks(String id);
}
