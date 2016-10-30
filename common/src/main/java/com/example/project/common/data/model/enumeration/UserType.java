package com.example.project.common.data.model.enumeration;

public enum UserType {

    ADMINISTRATOR   (1, "administrator"),
    MANAGER         (2, "manager"),
    USER            (3, "user");

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
