package iftm.edu.br.ex3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iftm.edu.br.ex3.domain.Post;
import iftm.edu.br.ex3.domain.PostComment;
import iftm.edu.br.ex3.service.PostCommentService;

@RestController
@RequestMapping("/posts")
public class PostCommentController {

    @Autowired
    private PostCommentService postCommentService;

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Post> addComment(@PathVariable Long postId, @RequestBody PostComment comment) {
        Post post = postCommentService.addComment(postId, comment.getReview());
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Post> removeComment(@PathVariable Long postId, @PathVariable Long commentId) {
        Post post = postCommentService.removeComment(postId, commentId);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
