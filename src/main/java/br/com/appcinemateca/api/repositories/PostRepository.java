package br.com.appcinemateca.api.repositories;

import br.com.appcinemateca.api.domain.Ator;
import br.com.appcinemateca.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
