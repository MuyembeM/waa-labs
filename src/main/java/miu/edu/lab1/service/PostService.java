package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAll();

    Post findById(int id);

    void save(Post p);

    void delete(int id);

    void update(int id, Post p);

    List<Post>findAllPostsMadeBy(String author);
}
