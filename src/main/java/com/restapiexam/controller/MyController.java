package com.restapiexam.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapiexam.entity.Enquiry;
import com.restapiexam.entity.User;
import com.restapiexam.exception.InvalidUserException;
import com.restapiexam.exception.UserNotFoundException;
import com.restapiexam.service.EnquiryService;
import com.restapiexam.service.UserService;
@RestController
@RequestMapping("api/v1")
public class MyController {
	@Autowired
	private EnquiryService enquiryService;
	@Autowired
	private UserService userService;
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		if(userService.authenticateUser(user) == null)
				throw new UserNotFoundException("User not found");
		else if(userService.authenticateUser(user) != null) {
			if(userService.authenticateUser(user).getRole().equalsIgnoreCase("Student"))
				return user;
		else
			throw new InvalidUserException("Invalid UserName");
		}
		User u = this.userService.addUser(user);
		System.out.println(user);
		return u;
	}
	@PutMapping("/user/{id}")
	public User editUser(User user) {
		User u = this.userService.editUser(user);
		System.out.println(user);
		return u;
	}
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable("id") int id) {
		User u = this.userService.deleteUser(id);
		System.out.println(id);
		return u;
	}
	@GetMapping("/user/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {

		return userService.getUserByName(name);
	}
	@GetMapping("/enquiry/{title}")
	public List<Enquiry> getEnquiryByTitle(@PathVariable("title") String enqTitle) {

		return enquiryService.getEnquiryByTitle(enqTitle);
	}
	@GetMapping("/enquiry/today")
	public List<Enquiry> getEnquiryByToday(Date d) 
	{

		return enquiryService.getEnquiryByToday(d);
	}

	@GetMapping("/enquiry")
	public List<Enquiry> getAllEnquiries(Enquiry enq) {

		return enquiryService.getAllEnquiries(enq);
	}

	@PostMapping("/enquiry")
	public Enquiry addEnquiry(Enquiry enq) {
		Enquiry e = this.enquiryService.addEnquiry(enq);
		System.out.println(enq);
		return e;
	}

	@PutMapping("/enquiry/{id}")
	public Enquiry editEnquiry(@RequestBody Enquiry enq, @PathVariable("id") int id) {
		Enquiry e = this.enquiryService.editEnquiry(enq,id);
		System.out.println(enq);
		return e;
	}

	@DeleteMapping("/enquiry/{id}")
	public Enquiry deleteEnquiry(@PathVariable("id") int id) {
		Enquiry e = this.enquiryService.deleteById(id);
		System.out.println(id);
		return e;
	}
	
}
