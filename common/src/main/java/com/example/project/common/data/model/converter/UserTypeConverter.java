package com.example.project.common.data.model.converter;

import com.example.project.common.data.model.enumeration.UserType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserType userType) {
        return userType.getKey();
    }

    @Override
    public UserType convertToEntityAttribute(Integer key) {
        return UserType.valueOf(key);
    }
}
