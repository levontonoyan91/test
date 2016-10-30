package com.example.project.data.service;

import com.example.project.common.data.model.Task;
import com.example.project.common.exception.InternalServerException;

import java.util.List;

public interface TaskService {

    void add(Task task) throws InternalServerException;

    Task getByID(long id) throws InternalServerException;

    List<Task> getAll() throws InternalServerException;

    void edit(Task task) throws InternalServerException;

    void removeByID(long id) throws InternalServerException;
}
