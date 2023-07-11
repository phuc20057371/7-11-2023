package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Khoahoc;
import com.example.demo.service.KhoahocService;

import redis.clients.jedis.Jedis;

@RestController
public class KhoahocController {
	private KhoahocService service;

	public KhoahocController(KhoahocService service) {
		super();
		this.service = service;
	}
	@PostMapping
	public ResponseEntity<Khoahoc> saveEmployee(@RequestBody Khoahoc kh){
		return new ResponseEntity<Khoahoc>(service.createKhoahoc(kh), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Khoahoc> getEmployeeById(@PathVariable("id") long id){
		return new ResponseEntity<Khoahoc>(service.findOne(id), HttpStatus.OK);
	}
	@GetMapping("redis/{id}")
	public ResponseEntity<Khoahoc> getEmployeeByIdbyRedis(@PathVariable("id") long id){
		return new ResponseEntity<Khoahoc>(service.findOneRedis(id), HttpStatus.OK);
	}
	
	
}









