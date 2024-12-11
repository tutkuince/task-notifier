package com.incetutku.taskservice.entity;

public enum Status {

    OPEN("Open"), IN_PROGRESS("In_Progress"), CLOSED("Closed");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
