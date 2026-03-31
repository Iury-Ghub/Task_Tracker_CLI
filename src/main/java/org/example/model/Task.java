package org.example.model;

import org.example.enums.Progress;

import java.time.LocalDate;

public class Task {
    private static int cont = 0;
    private int id=0;
    private String description;
    private String progress;
    private final LocalDate createdAt = LocalDate.now();
    private LocalDate updatedAt;

    public Task(){

    }
    public Task(String description) {
        this.id = cont;
        cont++;
        this.description = description;
        this.progress = "To Do";
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

    public String getProgress() {
        return this.progress;
    }

    public void setProgress(String progress) {
        this.updatedAt = LocalDate.now();
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
                '}';
    }
}
