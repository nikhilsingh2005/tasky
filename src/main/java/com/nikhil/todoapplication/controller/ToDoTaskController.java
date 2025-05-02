package com.nikhil.todoapplication.controller;

import com.nikhil.todoapplication.entity.ToDoTask;
import com.nikhil.todoapplication.service.ToDoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class ToDoTaskController {
    @Autowired
    private ToDoTaskService toDoTaskService;

    public ToDoTaskController(ToDoTaskService toDoTaskService) {
        this.toDoTaskService = toDoTaskService;
    }

    @GetMapping("/list")
    public String getAllTasks(Model model) {
        List<ToDoTask> tasks = toDoTaskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks/task-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        ToDoTask toDoTask = new ToDoTask();
        model.addAttribute("toDoTask", toDoTask);
        return "tasks/task-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("taskId") int id, Model model) {
        ToDoTask toDoTask = toDoTaskService.getTaskById(id);
        model.addAttribute("toDoTask", toDoTask);
        return "tasks/task-form";
    }

    @PostMapping("/save")
    public String addNewTask(@ModelAttribute("toDoTask") ToDoTask toDoTask) {
        toDoTaskService.saveTask(toDoTask);
        return "redirect:/tasks/list";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam("taskId") int id) {
        toDoTaskService.deleteTask(id);
        return "redirect:/tasks/list";
    }

    @PostMapping("/markCompleted")
    public String markTaskCompleted(@RequestParam("taskId") int id) {
        ToDoTask task = toDoTaskService.getTaskById(id);
        if (task != null) {
            task.setStatus("Completed");
            toDoTaskService.saveTask(task);
        }
        return "redirect:/tasks/list";
    }
}
