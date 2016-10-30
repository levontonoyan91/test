package com.example.project.data.dao;

import com.example.project.common.data.model.Task;
import com.example.project.common.exception.InternalServerException;

import java.util.List;

public interface TaskDao {

    void add(Task task) throws InternalServerException;

    Task getByID(long id) throws InternalServerException;

    List<Task> getAll() throws InternalServerException;

    void edit(Task task) throws InternalServerException;

    void removeByID(long id) throws InternalServerException;
}
