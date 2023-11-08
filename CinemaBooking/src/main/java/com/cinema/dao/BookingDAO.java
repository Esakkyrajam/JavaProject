package com.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.model.Booking;
import com.cinema.model.SeatEntity;
@Repository
public interface BookingDAO extends JpaRepository<Booking, Long>{
	

}
