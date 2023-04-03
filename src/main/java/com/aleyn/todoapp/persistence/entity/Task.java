package com.aleyn.todoapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data // Gets the Getter and Setter
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "estimated_completion_date", nullable = false)
    private LocalDateTime eta; // estimated completion date

    @Column(name = "finished")
    private boolean finished;

    @Column(name = "task_status")
    private TaskStatus taskStatus;

}
