package com.enbasis.planner.service;

import com.enbasis.planner.entity.Planner;
import com.enbasis.planner.repository.PlannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlannerService {

    private PlannerRepository repository;
    
    private PlannerService(PlannerRepository repository) {
    	this.repository = repository;
    }

    public List<Planner> getAllTasks() {
        return repository.findAll();
    }

    public Planner getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Planner createTask(Planner task) {
        task.setCompleted(false);
        return repository.save(task);
    }

    public Planner updateTask(Long id, Planner updatedTask) {

        Planner existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existing.setTitle(updatedTask.getTitle());
        existing.setDescription(updatedTask.getDescription());
        existing.setCompleted(updatedTask.isCompleted());
        existing.setDueDate(updatedTask.getDueDate());

        return repository.save(existing);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public List<Planner> getCompletedTasks() {
        return repository.findByCompleted(true);
    }

    public List<Planner> getPendingTasks() {
        return repository.findByCompleted(false);
    }
}
