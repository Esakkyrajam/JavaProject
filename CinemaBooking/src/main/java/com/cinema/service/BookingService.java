package com.cinema.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cinema.dao.BookingDAO;
import com.cinema.dao.CineDAO;
import com.cinema.dao.SeatDAO;

import com.cinema.model.Booking;
import com.cinema.model.SeatEntity;
import com.cinema.model.UserEntity;



@Service
public class BookingService {
    
    private BookingDAO bookingdao;
    private CineDAO cinedao;
    
    @Autowired
    public Booking booking;
   // private UserEntity user;
    @Autowired
    private SeatEntity seatentity;
    @Autowired
    private CineService cineservice;
    
    @Autowired
    private SeatService seatservice;
    
    public BookingService(BookingDAO bookingdao, CineDAO cinedao, CineService cineservice) {
    	
		this.bookingdao = bookingdao;
		this.cinedao = cinedao;
		this.cineservice = cineservice;
		
		
		//this.user = user;
	}
   // Booking booking = new Booking();

//	public Booking createBookDateTime(LocalDate bookingDate, String showtime, String movieTitle) {
//		// TODO Auto-generated method stub
//		
//        booking.setShowtime(showtime);
//        booking.setBookingTime(bookingDate);
//        booking.setMovieTitle(movieTitle);
//        System.out.println(booking.getShowtime());
//        System.out.println(booking.getBookingTime());
//        return bookingdao.save(booking);
//		
//	}
	
	/*
	 * public Booking saveBooking(String selectedSeats, String priceString) {
	 * 
	 * 
	 * try { String[] selectedSeatNumbers = selectedSeats.split(",");
	 * List<SeatEntity> selectedSeatEntities = new ArrayList<>();
	 * 
	 * // Calculate the price per seat double pricePerSeat = 200.0; // Set your
	 * desired price per seat
	 * 
	 * // Create a new Booking entity //Booking booking = new Booking();
	 * 
	 * // Iterate through selectedSeatNumbers and create SeatEntity instances for
	 * (String seatNumber : selectedSeatNumbers) { //SeatEntity seatEntity = new
	 * SeatEntity(); seatentity.setSeatNumber(seatNumber);
	 * selectedSeatEntities.add(seatentity); }
	 * 
	 * // Set the selected seats for the Booking entity
	 * booking.setSelectedSeats(selectedSeatEntities);
	 * 
	 * // Calculate the total price if (priceString != null &&
	 * !priceString.isEmpty()) { try { double totalPrice =
	 * selectedSeatNumbers.length * pricePerSeat; booking.setPrice(totalPrice); }
	 * catch (NumberFormatException e) { // Handle the parsing error, log it, or
	 * take appropriate action System.out.println("Error parsing price: " +
	 * priceString); return null; // If parsing fails, return null or handle the
	 * error as needed } }
	 * 
	 * // Save the Booking entity to persist the selected seats and price in the
	 * database return bookingdao.save(booking); // Assuming you have a "bookingdao"
	 * for saving bookings } catch (Exception ex) {
	 * System.out.println("An error occurred: " + ex.getMessage()); // Handle the
	 * exception or rethrow it as needed // You can add code to handle the exception
	 * or rethrow it if necessary return null; } }
	 */

	
	/*
	 * public Booking createAndSaveBooking( LocalDate bookingDate, String showtime,
	 * String movieTitle, String selectedSeats, String priceString) {
	 * 
	 * try { String[] selectedSeatNumbers = selectedSeats.split("&");
	 * List<SeatEntity> selectedSeatEntities = new ArrayList<>();
	 * 
	 * // Calculate the price per seat double pricePerSeat = 200.0; // Set your
	 * desired price per seat
	 * 
	 * // Create a new Booking entity Booking booking = new Booking();
	 * 
	 * // Set the selected seats for the Booking entity for (String seatNumber :
	 * selectedSeatNumbers) { SeatEntity seatEntity = new SeatEntity();
	 * seatEntity.setSeatNumber(seatNumber); selectedSeatEntities.add(seatEntity); }
	 * 
	 * //booking.setSelectedSeats(selectedSeatEntities); // Set the other properties
	 * for the Booking entity booking.setShowtime(showtime);
	 * booking.setBookingTime(bookingDate); booking.setMovieTitle(movieTitle);
	 * 
	 * // Calculate the total price if (priceString != null &&
	 * !priceString.isEmpty()) { try { double totalPrice =
	 * selectedSeatNumbers.length * pricePerSeat; booking.setPrice(totalPrice); }
	 * catch (NumberFormatException e) { // Handle the parsing error, log it, or
	 * take appropriate action System.out.println("Error parsing price: " +
	 * priceString); return null; // If parsing fails, return null or handle the
	 * error as needed } }
	 * 
	 * // Save the Booking entity to persist all the properties in a single row in
	 * the database return bookingdao.save(booking); // Assuming you have a
	 * "bookingdao" for saving bookings } catch (Exception ex) {
	 * System.out.println("An error occurred: " + ex.getMessage()); // Handle the
	 * exception or rethrow it as needed // You can add code to handle the exception
	 * or rethrow it if necessary return null; } }
	 * 
	 */
	
	
	
	  public Booking createBooking(UserEntity user) { 
		  //Booking booking = new Booking();
	  
		  booking.setUser(user); 
		  user.getBookings().add(booking);
	  
		  // Save both the user and the booking to the database.
		  cineservice.saveUser(user); 
		  // cinedao.save(user); 
		  bookingdao.save(booking);
		  return booking; 
	  }
	 
	 
	
	
	 public Booking createAndSaveBooking(
	            LocalDate bookingDate, String showtime, String movieTitle, List<String> selectedSeats, String price) {
	        try {
	  		  Booking booking = new Booking();

	            booking.setBookingTime(bookingDate);
	            booking.setShowtime(showtime);
	            booking.setMovieTitle(movieTitle);

	            List<SeatEntity> selectedSeatEntities = new ArrayList<>();
	            for (String seatNumber : selectedSeats) {
	                SeatEntity seatEntity = new SeatEntity();
	                seatEntity.setSeatNumber(seatNumber);
	                seatEntity.setBooking(booking); // Set the Booking for the SeatEntity
	                seatEntity.setBookedd(true); // Assuming you have a method for marking a seat as booked
	                selectedSeatEntities.add(seatEntity);
	            }
	            booking.setSelectedSeats(selectedSeatEntities);
	            booking.markSeatsAsBooked();
//	            double pricePerSeat = 200.0;
//	            double totalPrice = selectedSeats.size() * pricePerSeat;
	            double totalPrice = Double. parseDouble(price);
	            booking.setPrice(totalPrice);
	           
	            //cinedao.save(user);
    
	            

	            return bookingdao.save(booking); // Save the Booking entity to the database
	        } catch (Exception ex) {
	            System.out.println("An error occurred: " + ex.getMessage());
	            
	            return null;
	        }
	    }
	
	
	
	public List<Booking> getAllBookings() {
        return bookingdao.findAll(); 
    }


    public List<SeatEntity> findAvailableSeats(List<SeatEntity> selectedSeats) {
        List<SeatEntity> availableSeats = new ArrayList<>();
        
        for (SeatEntity seat : selectedSeats) {
            if (seat.isBookedd()) {
                
            	 seat.setAvailable(false);
            } else {
                availableSeats.add(seat);
            }
        }
        
        return availableSeats;
    }
    
    
    
	        
	    
	
}
