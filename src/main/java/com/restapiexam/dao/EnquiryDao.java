package com.restapiexam.dao;

import java.util.Date;
import java.util.List;

import com.restapiexam.entity.Enquiry;


public interface EnquiryDao {

	public List<Enquiry> getEnquiryByTitle(String enqTitle);

	public List<Enquiry> getEnquiryByDate(Date date);

	public List<Enquiry> getAllEnquiries(Enquiry enq);

	public void addEnquiry(Enquiry user);

	public void editEnquiry(Enquiry user);

	public void deleteById(int id);

}
