package isi.WorldCup.WorldCup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import isi.WorldCup.WorldCup.controller.service.UserService;
import isi.WorldCup.WorldCup.entities.User;
import isi.WorldCup.WorldCup.entities.UserDao;


@RestController
public class UserController {

	@Autowired 
	UserService userService;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public List<User> getAllUser() {
		List<User> users = userService.findAll();

        return users;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/supprimeruser/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.delete(id);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value ="/user/{id}") //URL
	public User afficherUser(@PathVariable int id){
		User user = userService.findById(id);
			return user;
	}

	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/updateuser/{id}")
	public UserDao updateUser(@PathVariable(value = "id") int id,
	                                        @RequestBody UserDao user) {

		User m = userService.findById(id);
	    
	   
		user.set_nom(user.get_nom());
		user.set_prenom(user.get_prenom());
		user.set_numTel(user.get_numTel());
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		

	   m = userService.save(user);
	    return user;
	}

	
	  @RequestMapping(value="/signup", method = RequestMethod.POST)
	    public User saveUser(@RequestBody UserDao user){
	        return userService.save(user);
	    }

	
}
