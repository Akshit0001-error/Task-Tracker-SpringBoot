package com.akshit.todo.taskcontroler;


import com.akshit.todo.entity.Task;
import com.akshit.todo.taskservice.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskControler {
    private final TaskService taskService;

    public TaskControler(TaskService taskService) {
        this.taskService = taskService;
    }

 @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
   }

 @PostMapping
   public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
  }

 @GetMapping("/{id}/delete")
  public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
 }

 @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
 }



    }

