package com.example.project.data.repository;

import com.example.project.common.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

    @Query(value = "SELECT IF(COUNT(id) = 0, 'false', 'true') FROM user " +
            " WHERE email= :email", nativeQuery = true)
    boolean isEmailExist(@Param("email") String email);

    @Query(value = "SELECT IF(COUNT(id) = 0, 'false', 'true') FROM user " +
            " WHERE email= :email AND id != :excludedUserID", nativeQuery = true)
    boolean isEmailExist(@Param("email") String email, @Param("excludedUserID") long excludedUserID);

    List<User> findByIdNotIn(List<Long> excludedUserIDs);
}
