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

import isi.WorldCup.WorldCup.entities.Match;
import isi.WorldCup.WorldCup.entities.Spectateur;
import isi.WorldCup.WorldCup.repository.SpectateurRepository;

@RestController
public class SpectateurController {
	
	@Autowired 
	SpectateurRepository spectateurRepository;
	
	@GetMapping("/spectateurs")
	public List<Spectateur> getAllSpectateurs() {
		List<Spectateur> spectateurs = spectateurRepository.findAll();

        return spectateurs;
	    
	}
	
	@GetMapping(value ="/spectateur/{id}") //URL
	public Spectateur afficherUnMatch(@PathVariable int id){
		Spectateur spectateur = spectateurRepository.findById(id);
			return spectateur;
	}
	
	
	@DeleteMapping("/supprimerspectateur/{id}")
	public void deleteSpectateur(@PathVariable int id) {
		spectateurRepository.deleteById(id);
	}
	
	
	@PostMapping("/addspectateur")
	public Spectateur createSpectateur( @RequestBody Spectateur spectateur) {
	    return spectateurRepository.save(spectateur);
	}
	
	
	
	
	

}
