package com.example.userservice.repository;

import com.example.userservice.entities.UserBudget;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserBudgetRepo extends JpaRepository<UserBudget, Long> {
    Optional<UserBudget> findByUserIdAndMonth(String userId, String month);

    List<UserBudget> findByUserId(String userId);

}
