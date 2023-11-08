package com.cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class UserEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(unique = true)
    private String username;
    private String email;
    private String pwd;

    	
	  @OneToMany(mappedBy = "user") // One user can have many bookings private
	  List<Booking> bookings;
	 
	  
	  public UserEntity() {
	        this.bookings = new ArrayList<>();
	    }  

	    
	    

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Booking> getBookings() {
		if (bookings == null) {
	        bookings = new ArrayList<>();
	    }
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}




	@Override
	public String toString() {
		return "UserEntity [Id=" + Id + ", username=" + username + ", email=" + email + ", pwd=" + pwd + ", bookings="
				+ bookings + "]";
	}
	
	
	
}
