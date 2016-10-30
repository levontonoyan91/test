package com.example.project.common.data.model.enumeration;

public enum TaskStatus {

    PENDING     (1, "pending"),
    IN_PROGRESS (2, "in_progress"),
    RESOLVED    (3, "resolved"),
    DONE        (4, "done");

    private int key;
    private String value;

    TaskStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static TaskStatus valueOf(final int key){
        for (TaskStatus taskStatus : TaskStatus.values()) {
            if (taskStatus.key == key){
                return taskStatus;
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
