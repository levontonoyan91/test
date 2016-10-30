package com.example.project.data.dao.impl;

import com.example.project.common.data.model.Task;
import com.example.project.common.exception.DatabaseException;
import com.example.project.data.dao.TaskDao;
import com.example.project.data.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskDaoImpl implements TaskDao {

    private TaskRepository taskRepository;

    @Autowired
    public TaskDaoImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(Task task) throws DatabaseException {
        try {
            taskRepository.save(task);
        }catch (Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Task getByID(long id) throws DatabaseException {
        try {
            return taskRepository.findOne(id);
        }catch (Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Task> getAll() throws DatabaseException {
        try {
            return taskRepository.findAll();
        }catch (Exception e){
            throw new DatabaseException(e);
        }

    }

//    @Override
//    public void edit(Task task) throws DatabaseException {
//        try {
//            taskRepository.editTask(task);
//        }catch (Exception e){
//            throw new DatabaseException(e);
//        }
//    }

    @Override
    public void removeByID(long id) throws DatabaseException {
        try {
            taskRepository.delete(id);
        }catch (Exception e){
            throw new DatabaseException(e);
        }
    }
}
