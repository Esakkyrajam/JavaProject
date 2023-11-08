package com.cinema.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.dao.SeatDAO;
import com.cinema.model.SeatEntity;
import com.cinema.model.UserEntity;
@Repository
public class SeatService {
	@Autowired
	private SeatDAO seatdao;
	
	
	
}
