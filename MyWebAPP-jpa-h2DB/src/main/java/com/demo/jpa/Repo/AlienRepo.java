package com.demo.jpa.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.jpa.model.Alien;

@Repository
public interface AlienRepo extends CrudRepository<Alien, Integer>{

}
