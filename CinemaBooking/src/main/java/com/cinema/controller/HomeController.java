package com.cinema.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinema.dao.BookingDAO;
import com.cinema.dao.SeatDAO;
import com.cinema.model.Booking;
import com.cinema.model.SeatEntity;
import com.cinema.model.UserEntity;
import com.cinema.service.BookingService;
import com.cinema.service.CineService;

import ch.qos.logback.classic.Logger;

@Controller
public class HomeController {

	private SeatDAO seatdao;
	private BookingService bookingservice;
	@Autowired
	private CineService service;
	private BookingDAO  bookingdao;

	public HomeController(SeatDAO seatdao, BookingService bookingservice, BookingDAO  bookingdao) {
		this.seatdao = seatdao;
		this.bookingdao = bookingdao;
		this.bookingservice = bookingservice;
		
	}
	
	

	@RequestMapping("/")			//@RequestMapping("")
	public String home() {
		return "Booking";
	}

	@RequestMapping("/registered")
	public String SaveTheUserIntoDB(UserEntity user, Model model) {
		// Check if a user with the same username already exists
		
		if (service.isUsernameExists(user.getUsername())) {
			// User with the same username already exists, set an error message
			model.addAttribute("error", "Username already exists. Please choose a different username.");
			return "Register";
		}
		bookingservice.createBooking(user);
		// Save the user if the username is unique
		//service.saveUser(user);
		
		return "success";		//	return "Booking";
	}

	@RequestMapping("/login")
	public String loginUrl() {
		return "login";
	}

	@RequestMapping("/logged-in")
	public String login(@RequestParam("username") String username, @RequestParam("password") String pwd, Model model) {
		if (username != null && pwd != null) {
			// Handle login logic here
			service.login(username, pwd);
			if (service.authenticate) {
				return "success";         //return "Booking";
			} else {
				// Failed login, show an error message
				model.addAttribute("error", "Invalid Username or Password");
				return "login";
			}
//		} else {
//			// Handle addPoster logic here
//			List<String> movieUrls = Arrays.asList("movie1.jpg", "movie2.jpg", "movie3.jpg"
//			// Add more movie URLs here
//			);
//
//			model.addAttribute("movies", movieUrls);
//			return "Booking";
		}
		return "success";
	}
	/*
	 * @RequestMapping("/bookTickets") public ResponseEntity<String>
	 * booktickts(@RequestParam("bookingDate") @DateTimeFormat(iso =
	 * DateTimeFormat.ISO.DATE) LocalDate bookingTime,
	 * 
	 * @RequestParam("showtime") String showtime, ModelAndView mav) {
	 * 
	 * LocalDate currentDate = LocalDate.now(); bookingTime.isBefore(currentDate);
	 * if (bookingTime.isBefore(currentDate)) { // The selected date is in the past;
	 * return an error response ResponseEntity<String> errormsg = new
	 * ResponseEntity<>
	 * ("Invalid booking date. Please select a date in the present or the future.",
	 * HttpStatus.BAD_REQUEST); mav. //AlertMsg return new ResponseEntity<>
	 * ("Invalid booking date. Please select a date in the present or the future.",
	 * HttpStatus.BAD_REQUEST); } String successMessagee =
	 * "Booking successful for seats: " + bookingTime + "at" + showtime; return new
	 * ResponseEntity<>(successMessagee, HttpStatus.OK);
	 * 
	 * 
	 * //return "seat"; }
	 */
	/*
	 * @RequestMapping("/view-seats") public String viewSeats() {
	 */

	/*
	 * @RequestMapping("/bookTickets") public String bookTickets(
	 * 
	 * @RequestParam("bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	 * LocalDate bookingDate,
	 * 
	 * @RequestParam("showtime") String showtime, Model model) {
	 * 
	 * //ModelAndView mav = new ModelAndView("bookTickets"); // Replace with your
	 * actual view name
	 * 
	 * LocalDate currentDate = LocalDate.now();
	 * 
	 * if (bookingDate.isBefore(currentDate)) { // The selected date is in the past;
	 * add an error message to the model model.addAttribute("errorMessage",
	 * "Pick a future date for your booking."); return "Booking";
	 * 
	 * }
	 * 
	 * // Your successful booking logic here...
	 * 
	 * //model.addAttribute("successMessage", "Booking successful for seats on " +
	 * bookingDate + " at " + showtime); return "seat"; }
	 * 
	 */
	  
	

	/*
	 * @GetMapping("/book-tickets") public String showBookingPage() { return
	 * "Booking"; }
	 */

	
	/*
	 * @PostMapping("/saveBooking") public String
	 * bookTickets(@RequestParam("bookingDate") @DateTimeFormat(iso =
	 * DateTimeFormat.ISO.DATE) LocalDate bookingDate,@RequestParam("showtime")
	 * String showtime, @RequestParam("movieTitle") String MovieTitle, Model model)
	 * { LocalDate currentDate = LocalDate.now();
	 * if(bookingDate.isBefore(currentDate)) {
	 * model.addAttribute("errorMessage","Pick a future date for your booking.");
	 * return "Booking"; // Return to the booking page with an error message }
	 * 
	 * // Continue with successful booking logic here...
	 * 
	 * // Save the booking to the database
	 * bookingservice.createBookDateTime(bookingDate, showtime, MovieTitle);
	 * 
	 * return "seatnew"; // Redirect to another page after a successful booking }
	 * 
	 * 
	 * @GetMapping("/saveBooking") public String bookSeats(@RequestParam(value =
	 * "selectedSeats", required = true) String
	 * selectedSeats, @RequestParam("price") String price) { // Save the booking to
	 * the database bookingservice.saveBooking(selectedSeats, price);
	 * 
	 * return "success"; }
	 * 
	 * 
	 */
	
	
	@GetMapping("/seatnew")
	public String showSeatPage() {
	    // Your code to display the "seat" HTML page
	    return "seatnew";
	}
	

    @GetMapping("/saveBooking")      //@GetMapping("/saveBooking")
    public String saveBooking(
    		@RequestParam(value = "movieTitle", required = false) String movieTitle,
    	    @RequestParam(value = "bookingDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
    	    @RequestParam(value = "showtime", required = false) String showtime,
    	    @RequestParam(value = "selectedSeats", required = false) List <String>  selectedSeats,
    	    @RequestParam(value = "price", required = false)String price,
    	    Model model) {
    		
    	if (selectedSeats == null || selectedSeats.isEmpty()) {
            model.addAttribute("errorMessage", "Please Select your seats.");
            return "Booking"; // Return to the booking page with an error message
        }
    	LocalDate currentDate = LocalDate.now();

        if (bookingDate.isBefore(currentDate)) {
            model.addAttribute("errorMessage", "Pick a future date for your booking.");
            return "Booking"; // Return to the booking page with an error message
        }
        // Create and save a Booking entity with all the data in the same row
        Booking booking = bookingservice.createAndSaveBooking(bookingDate, showtime, movieTitle, selectedSeats, price); 
         //booking = bookingservice.createBooking(user);
        if (booking == null) {
             //Handle the case where the booking creation or update failed
            return "error";
        }

        return "register";       //        return "success";
    }

	

	@GetMapping("/success")
    public String listBookings(Model model) {
        List<Booking> bookings = bookingservice.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "table";
    }

 
		  
		
	  
	  // Calculate the total price based on the number of selected seats int
	 //double pricePerSeat = 200.0; // You can adjust this based on your pricing int
	 //double totalPrice = selectedSeats.size() * pricePerSeat;
	  //bookingservice.createBooking(selectedSeats, totalPrice);
	  
	  
	  //bookingservice.createBooking(selectedSeats, totalPrice);
	  
	/*  return "table";
	  
	  
	  } 
	 */
	
	/*
	 * @PostMapping("/view-seats") public String bookSeats(
	 * 
	 * @RequestParam("selectedSeats") List<SeatEntity> selectedSeats,
	 * 
	 * @RequestParam("bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	 * LocalDate bookingDate,
	 * 
	 * @RequestParam("showtime") String showtime) {
	 * 
	 * // Calculate the total price based on the number of selected seats int
	 * pricePerSeat = 200; // You can adjust this based on your pricing double
	 * totalPrice = selectedSeats.size() * pricePerSeat;
	 * 
	 * // Call your booking service to store the booking details including the total
	 * price bookingservice.createBooking(selectedSeats, totalPrice);
	 * 
	 * 
	 * // Your other booking logic... Booking booking = new Booking(); // After
	 * successful booking, send a response with the booked seats and total price
	 * String successMessage = "Booking successful for seats: "+ booking.toString()
	 * + "Booking Date " + bookingDate + " at " + showtime; successMessage +=
	 * "<br>Total Price: Rs. " + totalPrice;
	 * 
	 * 
	 * return "login"; }
	 */
	
	
	




}
