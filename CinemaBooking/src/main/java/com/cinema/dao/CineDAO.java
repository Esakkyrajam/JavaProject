package com.cinema.dao;

import org.springframework.data.repository.CrudRepository;
import com.cinema.model.UserEntity;


public interface CineDAO extends CrudRepository<UserEntity, Integer> {
    
	UserEntity findByUsername(String username);
    
}

