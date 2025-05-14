package domain;

public class Task {
    private String id;
    private String description;
    private boolean completed;

    public Task(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public void maskAsCompleted() {
        this.completed = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
