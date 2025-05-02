package com.nikhil.todoapplication.service;

import com.nikhil.todoapplication.entity.ToDoTask;
import com.nikhil.todoapplication.repository.ToDoTaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoTaskService {
    private ToDoTaskRepo toDoTaskRepo;

    public ToDoServiceImpl(ToDoTaskRepo toDoTaskRepo) {
        this.toDoTaskRepo = toDoTaskRepo;
    }

    @Override
    public List<ToDoTask> getAllTasks() {
        return toDoTaskRepo.findAllByOrderByStatusDesc();
    }

    @Override
    public ToDoTask getTaskById(int id) {
        return toDoTaskRepo.findById(id).orElse(null);
    }

    @Override
    public ToDoTask saveTask(ToDoTask toDoTask) {
        return toDoTaskRepo.save(toDoTask);
    }

    @Override
    public ToDoTask updateTask(ToDoTask toDoTask) {
        return toDoTaskRepo.save(toDoTask);
    }

    @Override
    public void deleteTask(int id) {
        toDoTaskRepo.deleteById(id);
    }
}
