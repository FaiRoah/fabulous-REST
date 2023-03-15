package simpleAPI.app.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import simpleAPI.app.rest.repo.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByFirstName(String firstName);
	List<User> findByAge(int age);
	User findFirstByAge(int age);
	List<User> findByLastName(String lastName);
}
