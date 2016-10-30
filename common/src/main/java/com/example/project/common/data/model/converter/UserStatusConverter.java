package com.example.project.common.data.model.converter;

import com.example.project.common.data.model.lcp.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserStatus userType) {
        return userType.getKey();
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer key) {
        return UserStatus.valueOf(key);
    }
}
