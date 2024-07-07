package iftm.edu.br.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import iftm.edu.br.ex3.domain.Post;
import iftm.edu.br.ex3.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post createPost(String title) {
        Post post = new Post();
        post.setTitle(title);
        return postRepository.save(post);
    }

    @Transactional
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
