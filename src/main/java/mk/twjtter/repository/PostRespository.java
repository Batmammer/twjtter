package mk.twjtter.repository;

import mk.twjtter.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRespository extends CrudRepository<Post, Long> {
    List<Post> findAllByUser_nameOrderByPublicationTimeDesc(String name);
    List<Post> findAllByUser_nameInOrderByPublicationTimeDesc(Set<String> names);
}
