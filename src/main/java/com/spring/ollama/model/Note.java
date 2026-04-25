package com.spring.ollama.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String title;
    @Column(columnDefinition = "TEXT") private String content;
    @Column(nullable = false) private String category;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "updated_at") private LocalDateTime updatedAt;

    @PrePersist protected void onCreate() { createdAt = updatedAt = LocalDateTime.now(); }
    @PreUpdate  protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    public Note() {}
    public Note(String title, String content, String category) { this.title=title; this.content=content; this.category=category; }

    public Long getId() { return id; }
    public String getTitle() { return title; } public void setTitle(String t) { title=t; }
    public String getContent() { return content; } public void setContent(String c) { content=c; }
    public String getCategory() { return category; } public void setCategory(String c) { category=c; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
