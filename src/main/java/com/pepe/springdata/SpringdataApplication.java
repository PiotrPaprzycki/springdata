package com.pepe.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.activation.DataHandler;
import java.util.Optional;

@SpringBootApplication
public class SpringdataApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringdataApplication.class, args);

        TaskRepository taskRepository = context.getBean(TaskRepository.class);
//        Task s = new Task();
//        s.setDescription("TODO");
//        taskRepository.save(s);
//        displayUser(taskRepository);
    }

    private static void displayUser(TaskRepository taskRepository) {
        long id = 4L;
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            taskOptional.get();
            System.out.println("Task description: " + taskOptional.get().getDescription().toString());
        } else {
            System.out.println("Task o id " + id + "nie istnieje");
        }
    }

}
