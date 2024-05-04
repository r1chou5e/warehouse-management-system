package com.giaphu.warehousemanagement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giaphu.warehousemanagement.dao.UserRepository;
import com.giaphu.warehousemanagement.exception.NotFoundException;
import com.giaphu.warehousemanagement.models.dtos.UserDTO;
import com.giaphu.warehousemanagement.models.entities.User;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<UserDTO> getUsersList() {
		List<User> users = (List<User>) userRepository.findAll();
		List<UserDTO> userDtoList = users.stream().map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return userDtoList;
	}

	@Override
	public UserDTO getUserById(int id) {
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
