package com.aleyn.todoapp.service;

import com.aleyn.todoapp.exceptions.ToDoExceptions;
import com.aleyn.todoapp.mapper.TaskInDTO_ToTask;
import com.aleyn.todoapp.persistence.entity.Task;
import com.aleyn.todoapp.persistence.entity.TaskStatus;
import com.aleyn.todoapp.persistence.repository.TaskRepository;
import com.aleyn.todoapp.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskInDTO_ToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTO_ToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.taskRepository.save(task);
    }

    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        if (!this.taskRepository.existsById(id)) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        if (!this.taskRepository.existsById(id)) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }

}
