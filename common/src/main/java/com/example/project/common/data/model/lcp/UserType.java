package com.example.project.common.data.model.lcp;

public enum UserType {

    ADMIN           (1, "admin"),
    USER            (2, "user"),
    MANAGER         (3, "manager");


    private int key;
    private String value;

    UserType(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static UserType valueOf(final int key){
        for (UserType userType : UserType.values()) {
            if (userType.key == key){
                return userType;
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
