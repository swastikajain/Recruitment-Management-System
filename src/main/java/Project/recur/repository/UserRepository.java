package Project.recur.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import Project.recur.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}