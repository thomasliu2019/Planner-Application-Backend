package com.enbasis.planner.controller;

import com.enbasis.planner.entity.Planner;
import com.enbasis.planner.service.PlannerService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PlannerController {

	@Autowired
    private PlannerService service;

    @GetMapping
    public List<Planner> getAll() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Planner getById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @PostMapping
    public Planner create(@RequestBody Planner task) {
        return service.createTask(task);
    }

    @PutMapping("/{id}")
    public Planner update(@PathVariable Long id,
                       @RequestBody Planner task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }

    @GetMapping("/completed")
    public List<Planner> getCompleted() {
        return service.getCompletedTasks();
    }

    @GetMapping("/pending")
    public List<Planner> getPending() {
        return service.getPendingTasks();
    }
}
