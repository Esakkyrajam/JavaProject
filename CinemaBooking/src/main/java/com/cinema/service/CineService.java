package com.cinema.service;




import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cinema.dao.BookingDAO;
import com.cinema.dao.CineDAO;

import com.cinema.model.UserEntity;

@Service
@Component
public class CineService {
	public boolean authenticate = false;	
	private CineDAO cinedao;
	private UserEntity userentity;
	private BookingDAO bookingdao;
		
		public CineService(CineDAO cinedao,BookingDAO bookingdao) {
			this.cinedao = cinedao;
			this.bookingdao = bookingdao;
		}
		
		public void saveUser(UserEntity user) {
			cinedao.save(user);	
			//bookingdao.save(booking);
		}
		
		
		public UserEntity login(String username,String pwd) {
			UserEntity userentity = cinedao.findByUsername(username);
			System.out.println(userentity.toString());
			authenticate = false;
			if(userentity!=null && userentity.getPwd().equals(pwd)) {
			authenticate = true;
			return userentity;
				}
			return null;
		}
		
		public boolean isUsernameExists(String username) {
	        // Check if a user with the same username already exists in the database
	        UserEntity existingUser = cinedao.findByUsername(username);
	        return existingUser != null;
	    }
		
		
		

		
		
}
 