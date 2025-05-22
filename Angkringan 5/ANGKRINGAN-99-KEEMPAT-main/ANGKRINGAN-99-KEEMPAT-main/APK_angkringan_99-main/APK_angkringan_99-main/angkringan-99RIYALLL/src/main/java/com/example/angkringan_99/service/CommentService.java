package com.example.angkringan_99.service;

import com.example.angkringan_99.model.Comment;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CommentService {

    private final Map<Long, Comment> commentStore = new LinkedHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    @jakarta.annotation.PostConstruct
    public void init() {
        // Adding some sample comments with professions
        addComment(new Comment(null, "Alice", "Great work!", "Designer", 5));
        addComment(new Comment(null, "Bob", "Needs improvement", "Developer", 3));
    }

    public Collection<Comment> getAllComments() {
        return commentStore.values();
    }

    public Comment addComment(Comment comment) {
        long id = idCounter.incrementAndGet();
        comment.setId(id);
        commentStore.put(id, comment);
        return comment;
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        Comment existing = commentStore.get(id);
        if (existing == null) {
            return null;
        }
        existing.setName(updatedComment.getName());
        existing.setComment(updatedComment.getComment());
        existing.setProfession(updatedComment.getProfession());
        existing.setRating(updatedComment.getRating());
        return existing;
    }

    public boolean deleteComment(Long id) {
        return commentStore.remove(id) != null;
    }
    
}
