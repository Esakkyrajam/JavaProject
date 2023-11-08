package com.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.model.SeatEntity;
@Repository
public interface SeatDAO extends CrudRepository<SeatEntity, Long>{
		
	List<SeatEntity> findBySeatNumberIn(List<String> seatNumbers);
	
	 }
