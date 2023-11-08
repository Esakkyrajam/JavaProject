package com.cinema.model;



import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
//seatNumber
import org.springframework.stereotype.Component;

@Entity
@Component
public class Booking {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "booking_seat",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<SeatEntity> selectedSeats; // Store selected seats as a list of SeatEntity

    @Column
    private LocalDate bookingTime;

    @Column
    private String showtime;

    @Column
    private String movieTitle;

    @Column
    private double price; // Price per seat

    // Constructors, getters, setters, and other fields


    // Constructors, getters, setters, etc.
    public Booking() {
		// TODO Auto-generated constructor stub
	}
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<SeatEntity> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(List<SeatEntity> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	public LocalDate getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDate bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void markSeatsAsBooked() {
        for (SeatEntity seatentity : selectedSeats) {
            seatentity.setBookedd(true);
        }
	
	}
	

	
	

}