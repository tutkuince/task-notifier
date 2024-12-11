package com.incetutku.taskservice.entity;

public enum PriorityType {
    URGENT("Urgent"), LOW("LOW"), HIGH("High");

    private String type;

    PriorityType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
