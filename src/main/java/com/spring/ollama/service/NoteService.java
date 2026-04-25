package com.spring.ollama.service;
import com.spring.ollama.model.Note;
import com.spring.ollama.repository.NoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository repo;
    public NoteService(NoteRepository repo) { this.repo = repo; }

    public List<Note> getAll() { return repo.findAll(); }
    public Note getById(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found: "+id)); }
    public Note create(Note n) { return repo.save(n); }
    public Note update(Long id, Note u) {
        Note e = getById(id);
        e.setTitle(u.getTitle()); e.setContent(u.getContent()); e.setCategory(u.getCategory());
        return repo.save(e);
    }
    public void delete(Long id) { repo.deleteById(id); }
    public List<Note> findByCategory(String c) { return repo.findByCategoryIgnoreCase(c); }
    public List<Note> search(String k) { return repo.findByTitleContainingIgnoreCase(k); }
}
