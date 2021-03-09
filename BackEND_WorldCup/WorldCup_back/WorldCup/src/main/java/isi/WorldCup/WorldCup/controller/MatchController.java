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
import isi.WorldCup.WorldCup.repository.MatchRepository;

@RestController
public class MatchController {
	
	@Autowired 
	MatchRepository matchRepository;
	
	@GetMapping("/matchs")
	public List<Match> getAllMatch() {
		List<Match> matchs = matchRepository.findAll();

        return matchs;
	    
	}
	
	@GetMapping(value ="/match/{id}") //URL
	public Match afficherUnMatch(@PathVariable int id){
		Match match = matchRepository.findById(id);
			return match;
	}
	
	@PostMapping("/addmatch")
	public Match createMatch( @RequestBody Match match) {
	    return matchRepository.save(match);
	}
	
	@DeleteMapping("/supprimerematch/{id}")
	public void deleteConsultation(@PathVariable int id) {
		matchRepository.deleteById(id);
	}
	
	@PutMapping("/updatematch/{id}")
	public Match updateMatch(@PathVariable(value = "id") Integer Id,
	                                        @RequestBody Match match) {

	    Match m = matchRepository.findById(Id).orElseThrow(null);
	    
	   
	    match.set_dateMatch(match.get_dateMatch());
	    match.set_deuxiemeEquipe(match.get_deuxiemeEquipe());
	    match.set_premiereEquipe(match.get_premiereEquipe());
	    match.set_nbSpectateur(match.get_nbSpectateur());
	   

	   m = matchRepository.save(match);
	    return match;
	}
	
	
	
	

}
