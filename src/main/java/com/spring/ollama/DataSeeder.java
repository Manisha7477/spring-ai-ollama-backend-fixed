package com.spring.ollama;
import com.spring.ollama.model.Note;
import com.spring.ollama.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final NoteRepository repo;
    public DataSeeder(NoteRepository repo) { this.repo = repo; }

    @Override
    public void run(String... args) {
        repo.save(new Note("Spring AI Overview","Spring AI provides abstractions for AI integrations in Spring apps, including chat, embeddings, and vector stores.","AI"));
        repo.save(new Note("Ollama Setup","Install Ollama: curl -fsSL https://ollama.com/install.sh | sh, then run: ollama pull llama3.2","Setup"));
        repo.save(new Note("RAG Pattern","Retrieval-Augmented Generation combines a vector store with an LLM to answer questions grounded in your own documents.","AI"));
        repo.save(new Note("H2 Console","H2 console at http://localhost:8081/h2-console. JDBC URL: jdbc:h2:mem:notesdb","Setup"));
        repo.save(new Note("REST API Tips","Use @CrossOrigin on controllers to allow React (port 3000) to call Spring Boot (port 8081).","Dev"));
    }
}
