package simpleAPI.app.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simpleAPI.app.rest.repo.UserRepo;
import simpleAPI.app.rest.repo.models.User;

@Service
public class MyService {
	
	@Autowired	
	UserRepo userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
	public void delete(User user) {
		userRepo.delete(user);
	}
	
	public Optional<User> findById(long id) {
		return userRepo.findById(id);
	}
	
	public User findByFirstName(String firstName) {
		return userRepo.findByFirstName(firstName);
	}

	public List<User> findByAge(int age) {
		return userRepo.findByAge(age);
	}
	
	public User findFirstByAge(int age) {
		return userRepo.findFirstByAge(age);
	}

	public List<User> findByLastName(String lastName) {
		return userRepo.findByLastName(lastName);
	}
	
}
