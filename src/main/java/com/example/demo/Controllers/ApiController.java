package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Models.Child;
import com.example.demo.Services.ApiService;
import com.example.demo.repositories.ChildRepository;

@RestController
public class ApiController {
	@Autowired
	ChildRepository rep;
	
	@Autowired 
	ApiService ser;
	
	public List<Child> asc(@PathVariable String field)
	{
		return ser.sort(field);
	}
	
	@GetMapping("/ge/{offset}/{pageSize}")
	public List<Child> paginat(@PathVariable int offset,@PathVariable int pageSize) {
		return ser.setPages(offset,pageSize);
	}
	@GetMapping("/geti/{offset}/{pages}/{field}")
	public List<Child> paginationsorting(@PathVariable int offset,@PathVariable int pages,@PathVariable String field)
	{
		Page<Child> pi=ser.pagesort(offset, pages,field);
		return pi.getContent();
	}
	
}
