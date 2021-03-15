package isi.WorldCup.WorldCup.repository;


import org.springframework.data.repository.CrudRepository;

import isi.WorldCup.WorldCup.entities.User;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);


}
