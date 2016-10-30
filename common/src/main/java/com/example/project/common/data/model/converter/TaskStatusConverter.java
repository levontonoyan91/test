package com.example.project.common.data.model.converter;

import com.example.project.common.data.model.enumeration.TaskStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, Integer>{

    @Override
    public Integer convertToDatabaseColumn(TaskStatus attribute) {
        return attribute.getKey();
    }

    @Override
    public TaskStatus convertToEntityAttribute(Integer key) {
        return TaskStatus.valueOf(key);
    }
}
