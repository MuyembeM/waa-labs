package miu.edu.lab1.repo.impl;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId = 4;

    static {
        posts = new ArrayList<>();

        Post p1 = new Post(1,"Summer Break","Nothing beats a day at the beach","Mike Muyembe");
        Post p2 = new Post(2,"Best Birthday Ever","Thank you for the iPhone 14 babe","Donald Nyagwande");
        Post p3 = new Post(3,"Spring vs .NET Core","I love the way Inversion of Control is handled in SpringBoot","Mike Muyembe");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }


    public List<Post> findAll(){
        return posts;
    }

    @Override
    public void save(Post p) {
        p.setId(postId);
        postId++;
        posts.add(p);
    }


    @Override
    public void delete(int id) {
        var post =posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
    }

    @Override
    public Post getById(int id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Post>findAllPostsMadeBy(String author){
        return posts.stream()
                .filter(p -> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

}
