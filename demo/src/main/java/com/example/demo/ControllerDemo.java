package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demodao.AlienRepo;

/**
 * 
 * @author Divya
 *
 */
@Controller
public class ControllerDemo {

	@Autowired
	AlienRepo ar;
	
	
	/**
	 * To save records
	 * @param a Alien data which needs to be stored
	 * @return View Page
	 */

	
	@RequestMapping(value="/result")
	public String  Result( Alien a)
	{
		ar.save(a);
		return "Submit";
		
	}
	
	/**
	 * Provides the count of Alien
	 * @return count of Alien record in DB
	 */
	@RequestMapping(value="/count")
	@ResponseBody()
	public String  Result( )
	{
		if(ar.count()==1)
		return "Count is one !!!Add more data";
		else 
			return "no problem";
		
	}
	
	/**
	 * Find the record of Alien with ID
	 * @param id Alien ID
	 * @param m Model will hold the data
	 * @return Alien record fetched by id
	 */
	@RequestMapping(value="/find" )
	
	public String  find( @RequestParam("id") int id ,Model m)
	{
		Optional<Alien> a=ar.findById(id);
		m.addAttribute(a);
		System.out.println(a);
		 System.out.println(ar.findByName("abc"));
		
		  System.out.println(ar.findByLangOrderBy("en"));
		 System.out.println(ar.findByIdGreaterThan(101));
		 

		return "Submit";		
	}
	
}
