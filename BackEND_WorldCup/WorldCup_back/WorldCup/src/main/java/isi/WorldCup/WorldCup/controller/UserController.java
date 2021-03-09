package isi.WorldCup.WorldCup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import isi.WorldCup.WorldCup.entities.User;

import isi.WorldCup.WorldCup.repository.UserRepository;

@RestController
public class UserController {

	@Autowired 
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();

        return users;
	    
	}
	
	@DeleteMapping("/supprimeruser/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	
	
	@GetMapping(value ="/user/{id}") //URL
	public User afficherUser(@PathVariable int id){
		User user = userRepository.findById(id);
			return user;
	}
	
	@PostMapping("/adduser")
	public User createUser( @RequestBody User user) {
	    return userRepository.save(user);
	}
	
	@PutMapping("/updateuser/{id}")
	public User updateUser(@PathVariable(value = "id") Integer Id,
	                                        @RequestBody User user) {

		User m = userRepository.findById(Id).orElseThrow(null);
	    
	   
		user.set_nom(user.get_nom());
		user.set_prenom(user.get_prenom());
		user.set_numTel(user.get_numTel());
		
	   

	   m = userRepository.save(user);
	    return user;
	}
	
	
}
