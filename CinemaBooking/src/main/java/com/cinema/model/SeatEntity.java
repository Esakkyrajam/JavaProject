package com.cinema.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;

@Entity
@Component
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String seatNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id") // This is the foreign key to the Booking entity
    private Booking booking;
    
    @Column
    private boolean isBookedd;


    @Column
    private boolean isAvailable;

    // Getters and setters


	    // Constructors, getters, setters, and other fields
	

	    public SeatEntity() {
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getseatNumber() {
			return seatNumber;
		}

		public void setseatNumber(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public Booking getBooking() {
			return booking;
		}

		public void setBooking(Booking booking) {
			this.booking = booking;
		}

		public boolean isBookedd() {
			return isBookedd;
		}

		public void setBookedd(boolean isBookedd) {
			this.isBookedd = isBookedd;
		}

		public boolean isAvailable() {
			return isAvailable;
		}

		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		
		
		
	

}
