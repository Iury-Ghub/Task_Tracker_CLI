package org.example.model;

import org.example.enums.Progress;
import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private Progress progress;
    private final LocalDate createdAt = LocalDate.now();
    private LocalDate updatedAt;

    public Task(){

    }
    public Task(int id,String description) {
        this.id = id;
        this.description = description;
        this.progress = Progress.TODO;
        this.updatedAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Progress getProgress() {
        return this.progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", description: '" + description + '\'' +
                ", progress: " + progress +
                ", createdAt: " + createdAt +
                ", updatedAt: " + updatedAt +
                "}";
    }
}
