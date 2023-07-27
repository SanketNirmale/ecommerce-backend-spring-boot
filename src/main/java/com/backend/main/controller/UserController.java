package com.backend.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.main.model.User;
import com.backend.main.repo.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    UserRepository repo;

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
    	User e = repo.findById(id).get();
		return e;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return repo.save(user);
    }
    
    @PostMapping("/addMany")
	public List<User> createEmp(@RequestBody List<User> user) {
		return repo.saveAll(user);
	}

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
       User u = repo.findById(id).get();
       repo.delete(u);
       return "Done and Dusted";
    }
    
    @GetMapping("/search")
    public User searchUserByEmailAndPassword(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        User user = repo.findByEmailAndPassword(email, password);
        return user;
    }
}

