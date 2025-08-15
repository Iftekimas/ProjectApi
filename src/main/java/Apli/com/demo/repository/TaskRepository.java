package Apli.com.demo.repository;

import Apli.com.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // No need to add methods here; JpaRepository provides CRUD methods
}