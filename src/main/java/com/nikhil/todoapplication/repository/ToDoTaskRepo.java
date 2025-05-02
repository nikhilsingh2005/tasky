package com.nikhil.todoapplication.repository;

import com.nikhil.todoapplication.entity.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoTaskRepo extends JpaRepository<ToDoTask, Integer> {
    List<ToDoTask> findAllByOrderByStatusDesc();
}
