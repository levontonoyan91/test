package com.example.project.common.data.model.enumeration;

/**
 * This enum is provided to control pages with user roles(spring security)
 */
public enum Role {

    ADMIN       (1, "admin"),
    USER        (2, "user");

    private int key;
    private String value;

    Role(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Role value(final String value) {
        for (Role role : Role.values()) {
            if (role.value == value) {
                return role;
            }
        }
        return null;
    }
}
