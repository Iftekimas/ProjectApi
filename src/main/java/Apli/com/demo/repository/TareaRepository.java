package Apli.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Apli.com.demo.model.Tarea, Long> {
    List<Apli.com.demo.model.Tarea> findByUsuarioId(Long usuarioId);
}
