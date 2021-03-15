package isi.WorldCup.WorldCup.controller.service;




import java.util.List;

import isi.WorldCup.WorldCup.entities.User;
import isi.WorldCup.WorldCup.entities.UserDao;





public interface UserService {

    
    List<User> findAll();
    void delete(int id);
    User findOne(String username);
    User findById(int id);
	User save(UserDao user);
}