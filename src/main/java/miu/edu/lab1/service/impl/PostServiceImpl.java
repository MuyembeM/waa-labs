package miu.edu.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.repo.PostRepo;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(int id) {
        return postRepo.getById(id);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id, Post p) {
        postRepo.update(id,p);
    }

    @Override
    public List<Post> findAllPostsMadeBy(String author) {
        return postRepo.findAllPostsMadeBy(author);
    }
}
