package com.profile.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.profile.constant.BaseEndpoint;
import com.profile.exception.DataNotFoundException;
import com.profile.mapper.PersonMapper;
import com.profile.model.Person;
import com.profile.object.vo.PersonVO;


@Service
public class PersonService {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Transactional
	public String save(Person person) {
		String personId = UUID.randomUUID().toString();
		setDefaultValue(person);
		personMapper.save(personId, person.getPersonName());
		return personId;
	}
	
	@Transactional
	public String update(Person person) {
		// handPerson
		handPerson(person);
		// update person
		personMapper.update(person.getPersonId(), person.getPersonName(), person.getBirthDay(), person.getBirthTime());
		return person.getPersonId();
	}
	
	@Transactional
	public String delete(Person person) {
		// 1. delete personSign by personId
		String deleteUrl = BaseEndpoint.ZodiacSign.BASE_ENDPOINT + "/personSign/" + person.getPersonId();
		restTemplate.delete(deleteUrl);
		// 2. delete person
		personMapper.delete(person.getPersonId());
		return person.getPersonId();
	}
	
	public PersonVO findById(String personId) {
		return personMapper.findById(personId).orElseThrow(() -> new DataNotFoundException("這個id找不到對應資料"));
	}
	
	public List<PersonVO> findAll(String personName) {
		return personMapper.findAll(personName);
	}
	
	private void setDefaultValue(Person person) {
		if(person.getPersonName() == null) {
			person.setPersonName("未命名");
		}
	}
	
	private void handPerson(Person person) {
		PersonVO personEntity = findById(person.getPersonId());
		if(person.getPersonName() == null) {
			person.setPersonName(personEntity.getPersonName());
		}
		if(person.getBirthDay() == null) {
			person.setBirthDay(personEntity.getBirthDay());
		}
		if(person.getBirthTime() == null) {
			person.setBirthTime(personEntity.getBirthTime());
		}
	}
	
}
