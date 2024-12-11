package com.incetutku.taskservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@EqualsAndHashCode(of = {"id"})
public class Task extends CoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;

    @Column(length = 600)
    private String description;
    private String notes;

    @Column(length = 50)
    private String assignee;
    private Timestamp startDate;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    private PriorityType priorityType;
}
