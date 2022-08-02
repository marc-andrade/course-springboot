package com.example.demo.course.services;

import com.example.demo.course.entities.User;
import com.example.demo.course.repositories.UserRepository;
import com.example.demo.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj){
		return userRepository.save(obj);
	}

	public void delete(Long id){
		userRepository.findById(id);
		userRepository.deleteById(id);
	}
	public User update(Long id, User obj){
		User entity = userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}

	public void updateData(User entity, User obj){
		 entity.setName(obj.getName());
		 entity.setEmail(obj.getEmail());
		 entity.setPhone(obj.getPhone());

	}

}
