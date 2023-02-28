package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Hair;
import com.example.demo.service.HairService;

@RestController
public class HairController {
	@Autowired
	HairService service;
	
	@PostMapping("/hair")
	public String add(@RequestBody Hair hair)
	{
		return service.addHair(hair);
	}
	@GetMapping("/hair")
	public List<Hair> get()
	{
		return service.getHair();
	}
	@PutMapping("/hair")
	public String update(@RequestBody Hair hair)
	{
		return service.upadteHair(hair);
	}
	
	@DeleteMapping("/hair")
		public String delete(@RequestParam int id)
		{
		return service.deleteHairById(id);
		}
	@GetMapping("/hair/{field}")
	public List<Hair> babyWithSort(@PathVariable String field)
	{
		return service.getBabySorted(field);
	}
	@GetMapping("/hair/{offset}/{pageSize}")
	public List<Hair> babyWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		return service.getBabyWithPagination(offset, pageSize );
	}
	@GetMapping("/hair/{offset}/{pageSize}/{field}")
	public List<Hair> babyWithSortingAndPagination(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return service.getBabyWithSortingAndPagination(offset, pageSize,field );
	}

}