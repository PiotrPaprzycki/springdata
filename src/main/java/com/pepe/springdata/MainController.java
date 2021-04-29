package com.pepe.springdata;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private TaskRepository taskRepository;

    public MainController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

//        Task task = allTask.get(0);
//        task.setDescription("DONE");
//        taskRepository.save(task);
        model.addAttribute("emptyTask", new Task());
        return "home";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/alltasks")
    public String alltasks(Model model) {
        List<Task> allTask = taskRepository.findAll();
        model.addAttribute("allTask", allTask);
        return "tasks";
    }

    @GetMapping("/allToDoTasks")
    public String alltodotasks(Model model) {
        List<Task> allTask = taskRepository.findAllToDoTasks();
        model.addAttribute("allTask", allTask);
        return "tasks";
    }

}