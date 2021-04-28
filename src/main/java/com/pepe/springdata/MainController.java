package com.pepe.springdata;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private TaskRepository taskRepository;

    public MainController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Task> allTask = taskRepository.findAll();
//        Task task = allTask.get(0);
//        task.setDescription("DONE");
//        taskRepository.save(task);
        model.addAttribute("allTask", allTask);
        return "home";
    }
}
