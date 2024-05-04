package com.giaphu.warehousemanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giaphu.warehousemanagement.models.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}