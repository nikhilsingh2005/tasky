package com.nikhil.todoapplication.service;

import com.nikhil.todoapplication.entity.ToDoTask;

import java.util.List;

public interface ToDoTaskService {
    List<ToDoTask> getAllTasks();

    ToDoTask getTaskById(int id);

    ToDoTask saveTask(ToDoTask toDoTask);

    ToDoTask updateTask(ToDoTask toDoTask);

    void deleteTask(int id);
}
