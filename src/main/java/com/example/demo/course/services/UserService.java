package com.example.demo.course.services;

import com.example.demo.course.entities.User;
import com.example.demo.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findById(Long id) {
		
		return userRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("User not found"));
	}

	public User insert(User obj){
		return userRepository.save(obj);
	}
}
