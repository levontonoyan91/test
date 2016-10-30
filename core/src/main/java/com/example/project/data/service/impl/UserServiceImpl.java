package com.example.project.data.service.impl;

import com.example.project.common.data.internal.SessionUser;
import com.example.project.common.data.model.User;
import com.example.project.common.exception.DatabaseException;
import com.example.project.common.exception.EntityNotFoundException;
import com.example.project.common.exception.InternalServerException;
import com.example.project.data.dao.UserDao;
import com.example.project.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = InternalServerException.class)
    public void add(User user) throws InternalServerException {
        try {
            String encPassword = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encPassword);

            userDao.add(user);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        try {
            User user = userDao.getByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("User name not found!");
            }
            return new SessionUser(user);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email) throws InternalServerException {
        try {
            return userDao.isEmailExist(email);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email, Long excludedUserID) throws InternalServerException {
        try {
            return userDao.isEmailExist(email, excludedUserID);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public User getByID(long id) throws InternalServerException {
        try {
            return userDao.getByID(id);
        } catch (DatabaseException | EntityNotFoundException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public List<User> getAll() throws InternalServerException {
        try {
            return userDao.getAll();
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public List<User> getAll(List<Long> excludedUserIDs) throws InternalServerException {
        try {
            return userDao.getAll(excludedUserIDs);
        } catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = InternalServerException.class)
    public void edit(User user) throws InternalServerException {
        try {
            User origin = userDao.getByID(user.getId());
            user.setPassword(origin.getPassword());

            userDao.edit(user);
        } catch (DatabaseException | EntityNotFoundException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = InternalServerException.class)
    public void removeByID(long id) throws InternalServerException {
        try {
            userDao.removeByID(id);
        } catch (DatabaseException | EntityNotFoundException e) {
            throw new InternalServerException(e);
        }
    }

}
