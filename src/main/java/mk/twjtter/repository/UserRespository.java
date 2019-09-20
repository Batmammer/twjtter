package mk.twjtter.repository;

import mk.twjtter.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends CrudRepository<User, String> {
    Optional<User> findOneByName(String name);
    Boolean existsByName(String name);
}
