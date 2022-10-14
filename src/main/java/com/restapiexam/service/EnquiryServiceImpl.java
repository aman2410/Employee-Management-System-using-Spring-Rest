package com.restapiexam.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restapiexam.dao.EnquiryDao;
import com.restapiexam.entity.Enquiry;
import com.restapiexam.service.EnquiryService;


@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDao enquiryRepository;

	@Override
	public List<Enquiry> getEnquiryByTitle(String enqTitle) {
		List<Enquiry> e = enquiryRepository.getEnquiryByTitle(enqTitle);
		return e;
	}

	@Override
	public List<Enquiry> getEnquiryByToday(Date d) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = formatter.format(java.util.Calendar.getInstance().getTime());
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			List<Enquiry> e = enquiryRepository.getEnquiryByDate(date);
			if (e != null)
				return e;
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Enquiry enq) {
		List<Enquiry> enquiry = enquiryRepository.getAllEnquiries(enq);
		return enquiry;
	}

	@Override
	public Enquiry addEnquiry(Enquiry enq) {
		Enquiry e = new Enquiry();
		e.setEnqType(enq.getEnqType());
		e.setEnqTitle(enq.getEnqTitle());
		e.setEnqDesc(enq.getEnqDesc());
		e.setEnqDate(enq.getEnqDate());
		enquiryRepository.addEnquiry(e);
		return e;
	}

	@Override
	public Enquiry editEnquiry(Enquiry enq) {
		enquiryRepository.editEnquiry(enq);
		return null;
	}

	@Override
	public Enquiry deleteById(int id) {
		enquiryRepository.deleteById(id);
		return null;
	}

	@Override
	public Enquiry editEnquiry(Enquiry enq, int id) {

		Enquiry e = enq;
		if (e.getId() == id) {
			e.setEnqType(enq.getEnqType());
			e.setEnqTitle(enq.getEnqTitle());
			e.setEnqDesc(e.getEnqDesc());
			enquiryRepository.editEnquiry(e);
		}
		return e;
	}

}
