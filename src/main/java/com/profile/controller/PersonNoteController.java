package com.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.exception.InputDataErrorException;
import com.profile.model.PersonNote;
import com.profile.service.PersonNoteService;

import io.swagger.v3.oas.annotations.tags.Tag;

//@CrossOrigin(originPatterns = "*", allowCredentials = "true", maxAge = 3600)
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/personNote")
@Tag(name = "note api")
public class PersonNoteController {
	
	@Autowired
	private PersonNoteService personNoteService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody PersonNote PersonNote) {
		if(PersonNote.getPersonId() == null || PersonNote.getContent() == null) {
			throw new InputDataErrorException("personId和content皆不可以為null");
		}
		return ResponseEntity.ok(personNoteService.save(PersonNote));
	}
	
	@DeleteMapping(value = "/{personNoteId}")
	public ResponseEntity<?> delete(@PathVariable String personNoteId) {
		personNoteService.delete(personNoteId);
		return ResponseEntity.ok().build();
	}
}
