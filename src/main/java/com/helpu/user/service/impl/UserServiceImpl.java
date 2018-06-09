package com.helpu.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helpu.user.repository.UserRepository;
import com.helpu.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(timeout=1)
	public void add() {
		userRepository.update();
		userRepository.save();
	}
	
	

}
