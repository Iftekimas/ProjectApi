package Apli.com.demo.controller;

import Apli.com.demo.model.Tarea;
import Apli.com.demo.model.Usuario;
import Apli.com.demo.repository.TareaRepository;
import Apli.com.demo.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios/{usuarioId}/tareas")
public class TareaController {

    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;

    public TareaController(TareaRepository tareaRepository, UsuarioRepository usuarioRepository) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> listarTareas(@PathVariable Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tareaRepository.findByUsuarioId(usuarioId));
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@PathVariable Long usuarioId, @RequestBody Tarea tarea) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        tarea.setUsuario(usuario);
        Tarea nuevaTarea = tareaRepository.save(tarea);
        return ResponseEntity.ok(nuevaTarea);
    }

    @PutMapping("/{tareaId}/completar")
    public ResponseEntity<Tarea> completarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        Tarea tarea = tareaRepository.findById(tareaId).orElse(null);
        if (tarea == null || tarea.getUsuario() == null || !tarea.getUsuario().getId().equals(usuarioId)) {
            return ResponseEntity.notFound().build();
        }
        tarea.setCompletada(true);
        tareaRepository.save(tarea);
        return ResponseEntity.ok(tarea);
    }

    @PutMapping("/{tareaId}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId,
            @RequestBody Tarea tareaActualizada) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return tareaRepository.findById(tareaId)
                .filter(tarea -> tarea.getUsuario().getId().equals(usuarioId))
                .map(tarea -> {
                    tarea.setDescripcion(tareaActualizada.getDescripcion());
                    tarea.setCompletada(tareaActualizada.isCompletada());
                    return ResponseEntity.ok(tareaRepository.save(tarea));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{tareaId}")
    public ResponseEntity<Void> borrarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return tareaRepository.findById(tareaId)
                .filter(tarea -> tarea.getUsuario().getId().equals(usuarioId))
                .map(tarea -> {
                    tareaRepository.deleteById(tareaId);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
