package com.example.project.data.service.impl;

import com.example.project.common.data.model.Task;
import com.example.project.common.exception.DatabaseException;
import com.example.project.common.exception.InternalServerException;
import com.example.project.data.dao.TaskDao;
import com.example.project.data.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void add(Task task) throws InternalServerException {
        try {
            taskDao.add(task);
        }catch (Exception e){
            throw new InternalServerException(e);
        }
    }

    @Override
    public Task getByID(long id) throws InternalServerException {
        try {
            return taskDao.getByID(id);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public List<Task> getAll() throws InternalServerException {
        try {
            return taskDao.getAll();
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

//    @Override
//    public void edit(Task task) throws InternalServerException {
//        try {
//            taskDao.edit(task);
//        }catch (Exception e){
//            throw new InternalServerException(e);
//        }
//    }

    @Override
    public void removeByID(long id) throws InternalServerException {
        try {
            taskDao.removeByID(id);
        }catch (Exception e){
            throw new InternalServerException(e);
        }
    }
}
