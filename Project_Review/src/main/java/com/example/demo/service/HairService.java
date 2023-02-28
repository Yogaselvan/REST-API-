package com.example.demo.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Hair;
import com.example.demo.repository.HairRepository;
@Service
public class HairService {
	@Autowired
	HairRepository repository;
	public String addHair(Hair hair) 
	{
		repository.save(hair);
		return "Added";
	}
	public List<Hair> getHair()
	{
		return repository.findAll();
	}
	public String upadteHair(Hair hair)
	{
		repository.save(hair);
		return "Updated";
	}
	public String deleteHairById(int id) {
	    repository.deleteById(id);
	    return "Customer Deleted";
	}
	public List<Hair> getBabySorted(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	public List<Hair> getBabyWithPagination(@PathVariable int offset, @PathVariable int pageSize)
	{
		Page<Hair> page=repository.findAll(PageRequest.of(offset,pageSize));
		return page.getContent();
	}
	public List<Hair> getBabyWithSortingAndPagination(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize,Sort.by(field));
		Page<Hair> page=repository.findAll(paging);
		return page.getContent();
	}

}
