package isi.WorldCup.WorldCup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.WorldCup.WorldCup.entities.Match;



public interface MatchRepository extends JpaRepository<Match,Integer>{
	
	Match findById(int id);
}
