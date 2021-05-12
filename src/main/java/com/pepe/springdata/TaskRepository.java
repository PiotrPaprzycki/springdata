package com.pepe.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(Status status);

    Task findTaskById(Long id);
//    Task findAllByStatusIn(Status.DONE);
    @Query("SELECT t FROM Task t WHERE t.status NOT LIKE 'DONE'")
    List<Task> findNotDone();
}
