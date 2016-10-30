package com.example.project.common.data.model.lcp;

public enum UserStatus {

    ACTIVE      (1, "active"),
    PENDING     (2, "pending"),
    BLOCKED     (3, "blocked"),
    DELETED     (4, "deleted");

    private int key;
    private String value;

    UserStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static UserStatus valueOf(final int key){
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.key == key){
                return userStatus;
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
