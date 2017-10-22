package tn.formation.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.formation.boot.model.dao.UserRepository;
import tn.formation.boot.model.entities.User;

@Controller
@RequestMapping("api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/ajouter")
	public void ajouter(String firstName, String lastName, String login, String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setPassword(password);

		userRepository.save(user);
	}

	/**
	 * delete user by id
	 * 
	 * @param id
	 */
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable(name = "id") long id) {
		userRepository.delete(id);
	}

	/**
	 * delete all users
	 */
	@DeleteMapping("/user/")
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@GetMapping("/user/")
	public ResponseEntity<List<User>> getAllUser() {

		List<User> users = userRepository.findAll();
		if (users == null) {
			return new ResponseEntity<List<User>>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(name = "id") long id) {

		User user = userRepository.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@PutMapping("/user/modifier/{id}")
	public void editUser(@PathVariable(name = "id") long id, String firstName, String lastName, String login,
			String password) {

		User users = new User();
		users.setId(id);
		users.setFirstName(firstName);
		users.setLastName(lastName);
		users.setLogin(login);
		users.setPassword(password);

		userRepository.save(users);
	}

	@PutMapping("/user/")
	public ResponseEntity<Void> editUser(@RequestBody User user) {
		User userDb = userRepository.findOne(user.getId());
		if (userDb == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
