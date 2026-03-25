package org.example.model;

import org.example.enums.Progress;

import java.time.LocalDate;

public class Task {
    private static int cont = 0;
    private int id=0;
    private String description;
    private Progress progress;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Task(String description) {
        this.id = cont;
        cont++;
        this.description = description;
        this.progress = Progress.TODO;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
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
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
