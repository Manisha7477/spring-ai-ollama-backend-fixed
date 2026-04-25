package com.spring.ollama.controller;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {
    private final ChatClient chatClient;
    public ChatController(ChatClient.Builder b) { this.chatClient = b.build(); }

    @GetMapping("/chat")
    public String chat(@RequestParam String q) {
        return chatClient.prompt().user(q).call().content();
    }
}
