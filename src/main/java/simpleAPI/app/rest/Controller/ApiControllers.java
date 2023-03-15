package simpleAPI.app.rest.Controller; 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simpleAPI.app.rest.repo.UserRepo;
import simpleAPI.app.rest.repo.models.User;
import simpleAPI.app.rest.service.MyService;


@RestController
//@RequestMapping("/api")
public class ApiControllers {
	
	@Autowired
	private MyService service;
	
	@GetMapping(value = "")
	public String getEmptyPage() {
		return "Empty";
	}
	
	@GetMapping(value = "/")
	public String getWelcomePage() {
		return "Welcome";
	}
	
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return service.findAll();
	}
	
	@PostMapping(value="/save")
	public String saveUser(@RequestBody User user) {
		service.save(user);
		return "Saved user.";
	}
	
	@PutMapping(value = "update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User updatedUser = service.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setOccupation(user.getOccupation());
		updatedUser.setAge(user.getAge());
		service.save(updatedUser);
		return "Updated user.";
	}
	
	@DeleteMapping(value="delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = service.findById(id).get();
		service.delete(deleteUser);
		return "Deleted user with id: " + id;
	}
	
	@GetMapping(value="/users/first-name/{firstName}")
	public User findByFirstName(@PathVariable String firstName) {
		return service.findByFirstName(firstName);
	}
	
	@GetMapping(value="/users/age/{age}")
	public List<User> findByAge(@PathVariable int age) {
		return service.findByAge(age);
	}
	
	@GetMapping(value="/users/ages/{age}")
	public User findFirstByAge (@PathVariable int age) {
		return service.findFirstByAge(age);
	}
	
	@GetMapping(value="/users/last-name/{lastName}")
	public List<User> findByLastName(@PathVariable String lastName) {
		return service.findByLastName(lastName);
	}
	
	@GetMapping(value="/users/id/{id}")
	public Optional<User> findById(@PathVariable long id){
		return service.findById(id);
	}
}
