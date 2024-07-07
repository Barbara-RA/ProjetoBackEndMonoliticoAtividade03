package iftm.edu.br.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import iftm.edu.br.ex3.domain.Post;
import iftm.edu.br.ex3.domain.PostComment;
import iftm.edu.br.ex3.repository.PostCommentRepository;
import iftm.edu.br.ex3.repository.PostRepository;

import java.util.Optional;

@Service
public class PostCommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Transactional
    public Post addComment(Long postId, String review) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            PostComment comment = new PostComment();
            comment.setReview(review);
            post.addComment(comment);
            postRepository.save(post);
            return post;
        }
        return null;
    }

    @Transactional
    public Post removeComment(Long postId, Long commentId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        Optional<PostComment> optionalComment = postCommentRepository.findById(commentId);
        if (optionalPost.isPresent() && optionalComment.isPresent()) {
            Post post = optionalPost.get();
            PostComment comment = optionalComment.get();
            post.removeComment(comment);
            postRepository.save(post);
            return post;
        }
        return null;
    }
}
