package isi.WorldCup.WorldCup.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import isi.WorldCup.WorldCup.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findById(int id);

}
