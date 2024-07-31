package com.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.profile.constant.BaseEndpoint;
import com.profile.exception.InputDataErrorException;
import com.profile.model.Person;
import com.profile.service.PersonService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/person")
@Tag(name = "person api")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Person Person) {
		return ResponseEntity.ok(personService.save(Person));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Person Person) {
		if(Person.getPersonId() == null) {
			throw new InputDataErrorException("personId不可為空");
		}
		personService.update(Person);
		return ResponseEntity.ok(personService.update(Person));
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Person Person) {
		if(Person.getPersonId() == null) {
			throw new InputDataErrorException("personId不可為空");
		}
		personService.delete(Person);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/{personId}")
	public ResponseEntity<?> findById(@PathVariable String personId) {
		return ResponseEntity.ok().body(personService.findById(personId));
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(required = false) String personName) {
		System.out.println("personName = "+personName);
		return ResponseEntity.ok().body(personService.findAll(personName));
	}
	
	@GetMapping(value = "/test")
	public ResponseEntity<?> test() {
		System.out.println(BaseEndpoint.Gateway.IP);
		return ResponseEntity.ok().body(BaseEndpoint.Gateway.IP);
	}
	
}
