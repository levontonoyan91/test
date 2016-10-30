package com.example.project.data.dao;

import com.example.project.common.data.model.Task;
import com.example.project.common.exception.DatabaseException;

import java.util.List;

public interface TaskDao {

    void add(Task task) throws DatabaseException;

    Task getByID(long id) throws DatabaseException;

    List<Task> getAll() throws DatabaseException;

//    void edit(Task task) throws DatabaseException;

    void removeByID(long id) throws DatabaseException;
}
