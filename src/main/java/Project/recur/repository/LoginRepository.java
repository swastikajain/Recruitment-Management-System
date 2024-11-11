package Project.recur.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import Project.recur.model.Login;


public interface LoginRepository extends JpaRepository<Login, Integer> {

	Optional<Login> findByLoginId(int loginId);
}