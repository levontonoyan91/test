package com.example.project.data.service.impl;

import com.example.project.common.data.model.Task;
import com.example.project.common.exception.InternalServerException;
import com.example.project.data.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    @Override
    public void add(Task task) throws InternalServerException {

    }

    @Override
    public Task getByID(long id) throws InternalServerException {
        return null;
    }

    @Override
    public List<Task> getAll() throws InternalServerException {
        return null;
    }

    @Override
    public void edit(Task task) throws InternalServerException {

    }

    @Override
    public void removeByID(long id) throws InternalServerException {

    }
}
