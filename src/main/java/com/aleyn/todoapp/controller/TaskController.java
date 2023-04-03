package com.aleyn.todoapp.controller;

import com.aleyn.todoapp.persistence.entity.Task;
import com.aleyn.todoapp.persistence.entity.TaskStatus;
import com.aleyn.todoapp.service.TaskService;
import com.aleyn.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO implement JWT

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping(path = "/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping(path = "/mark_as_finished/{id}")
    public ResponseEntity<?> markAsFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build(); // when the operation is complete it returns 204 (no content) always
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
