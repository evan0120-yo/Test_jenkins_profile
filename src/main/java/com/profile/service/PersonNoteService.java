package com.profile.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.mapper.PersonNoteMapper;
import com.profile.model.PersonNote;

@Service
public class PersonNoteService {

	@Autowired
	private PersonNoteMapper personNoteMapper;
	
	public String save(PersonNote personNote) {
		String personNoteId = UUID.randomUUID().toString();
		personNoteMapper.save(personNoteId, personNote.getPersonId(), personNote.getContent());
		return personNoteId;
	}
	
	public void delete(String personNoteId) {
		personNoteMapper.delete(personNoteId);
	}
}
