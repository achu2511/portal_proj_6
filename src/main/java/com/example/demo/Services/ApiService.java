package com.example.demo.Services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Child;
import com.example.demo.repositories.ChildRepository;

@Service
public class ApiService {

	@Autowired
	ChildRepository rep;
	
	
	public List<Child> sort(String field)
	{
		return rep.findAll(Sort.by(Sort.Direction.DESC,field));
	}

	public Page<Child> pagesort(@PathVariable int offset,@PathVariable int pages,String field)
	{
		Pageable paging = PageRequest.of(pages, offset,Sort.by(field));
		return rep.findAll(paging);
	}
	
	public List<Child> setPages(@PathVariable int offset,@PathVariable int pageSize){
		Page<Child> page=rep.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
}
