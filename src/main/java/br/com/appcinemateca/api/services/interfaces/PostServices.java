package br.com.appcinemateca.api.services.interfaces;


import br.com.appcinemateca.api.domain.Post;
import br.com.appcinemateca.api.dto.PostDTO;

import java.util.List;

public interface PostServices {

    Post findById(Long id);
    List<Post> findAll();
    Post create(PostDTO obj);
    Post update(PostDTO obj);
    void delete(Long id);
}
