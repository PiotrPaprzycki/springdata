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

        long id = 1L;
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            taskOptional.get();
            System.out.println("Taks description: " + taskOptional.get().getDescription().toString());
        } else {
            System.out.println("Task o id " + id + "nie istnieje");
        }
    }

}
