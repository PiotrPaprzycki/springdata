package com.pepe.springdata;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("emptyTask", new Task());
        List<Task> allNotDoneTasks;
        List<Task> allDoneTasks;
        allNotDoneTasks = taskRepository.findNotDone();
        model.addAttribute("allNotDoneTasks", allNotDoneTasks);
        allDoneTasks = taskRepository.findAllByStatus(Status.DONE);
        model.addAttribute("allDoneTasks", allDoneTasks);
        return "home";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }

//    @GetMapping("/alltasks")
//    public String alltasks(Model model, @RequestParam(required = false) Status status) {
//        List<Task> allByStatus;
//        if (status != null) {
//            allByStatus = taskRepository.findAllByStatus(status);
//        } else {
//            allByStatus = taskRepository.findAll();
//        }
//        model.addAttribute("allTask", allByStatus);
//        return "tasks";
//    }

    @GetMapping("/done")
    public String markAsDone(Model model, @RequestParam(required = false) Long id) {

        Task task = taskRepository.findTaskById(id);
        task.setStatus(Status.DONE);
        taskRepository.save(task);
        return "redirect:/";
    }
}
