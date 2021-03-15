package isi.WorldCup.WorldCup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.WorldCup.WorldCup.entities.Spectateur;

public interface SpectateurRepository extends JpaRepository<Spectateur,Integer> {
	
	Spectateur findById(int id);

}
