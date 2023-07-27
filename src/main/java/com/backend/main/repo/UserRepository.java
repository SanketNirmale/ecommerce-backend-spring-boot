package com.backend.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.main.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	User findByEmailAndPassword(String email, String password);


}
