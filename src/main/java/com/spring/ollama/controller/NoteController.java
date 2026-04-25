package com.spring.ollama.controller;
import com.spring.ollama.model.Note;
import com.spring.ollama.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
public class NoteController {
    private final NoteService svc;
    public NoteController(NoteService svc) { this.svc = svc; }

    @GetMapping public List<Note> all() { return svc.getAll(); }
    @GetMapping("/{id}") public Note one(@PathVariable Long id) { return svc.getById(id); }
    @PostMapping public Note create(@RequestBody Note n) { return svc.create(n); }
    @PutMapping("/{id}") public Note update(@PathVariable Long id, @RequestBody Note n) { return svc.update(id,n); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { svc.delete(id); return ResponseEntity.noContent().build(); }
    @GetMapping("/category/{cat}") public List<Note> byCategory(@PathVariable String cat) { return svc.findByCategory(cat); }
    @GetMapping("/search") public List<Note> search(@RequestParam String q) { return svc.search(q); }
}
