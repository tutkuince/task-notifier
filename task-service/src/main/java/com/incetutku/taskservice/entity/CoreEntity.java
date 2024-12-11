package com.incetutku.taskservice.entity;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class CoreEntity implements Serializable {
    @CreatedDate
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
