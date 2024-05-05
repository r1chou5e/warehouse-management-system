package com.giaphu.warehousemanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.giaphu.warehousemanagement.models.dtos.UserDTO;
import com.giaphu.warehousemanagement.models.entities.User;

@Service
public interface UserService {

	public User createUser(User user);

	public List<UserDTO> getUsersList();

	public UserDTO getUserById(int id);

	public User deleteUser(int id);

	public User updateUser(int id, UserDTO user);

}
