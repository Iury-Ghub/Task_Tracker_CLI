package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.enums.Progress;
import org.example.model.Task;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.Arrays.stream;

public class TaskTracker {
    private final ObjectMapper mapper = new ObjectMapper();
    private final File archive = new File("tasks.json");

    public void addTask(String description) throws IOException {
        Task task = new Task(description);
        List<Task> tasks = loadTasks();
        tasks.add(task);
        mapper.writerWithDefaultPrettyPrinter().writeValue(archive,tasks);
    }
    public List<Task> loadTasks() throws IOException{
        if(!archive.exists() || archive.length() == 0){
            return new ArrayList<>();
        }
        return mapper.readValue(archive, new TypeReference<List<Task>>() {});
    }
    public void update(int targetId,String description) throws IOException{
        List<Task> tasks = loadTasks();

        Optional<Task> match = tasks.stream()
                .filter(t->t.getId()==targetId)
                .findFirst();

        if(match.isPresent()){
            Task t = match.get();
            t.setDescription(description);
            mapper.writerWithDefaultPrettyPrinter().writeValue(archive,tasks);
        }else {
            System.out.println(targetId+" Not found");
        }
    }
    public void delete(int targetId) throws IOException {
        List<Task> tasks = loadTasks();

        Optional<Task> match= tasks.stream()
                .filter(t->t.getId()==targetId)
                .findFirst();

        if(match.isPresent()){
            Task t = match.get();
            tasks.remove(t);
            mapper.writerWithDefaultPrettyPrinter().writeValue(archive,tasks);
        }else{
            System.out.println(targetId+" Not Found");
        }
    }
}
