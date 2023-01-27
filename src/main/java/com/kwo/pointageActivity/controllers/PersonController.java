package com.kwo.pointageActivity.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwo.pointageActivity.entities.Person;
import com.kwo.pointageActivity.services.PersonService;

@RestController
@RequestMapping({"/persons"})
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	//getting all person list
	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<Person> getPersons() {
		return(service.getPersons());
	}
	
	//getting a person by it id
	@RequestMapping(method=RequestMethod.GET ,value="/{mat}")
	public Person getPerson(@PathVariable int mat) {
		return(this.service.getPerson(mat));
	}
	
	//deleting a person
	@RequestMapping(method=RequestMethod.DELETE,value="/{mat}")
	public void deletPerson(@PathVariable int mat) {
		service.deletPerson(mat);
	}
	
	//putting a person
	@RequestMapping(method=RequestMethod.PUT,value="/{mat}")
	public void updatePerson(@PathVariable int mat,@RequestBody Person person) {
		person.setMat(mat);
		this.service.updatePerson(person);
	}
	
	//post a person
	@RequestMapping(method=RequestMethod.POST)
	public void createPerson(@RequestBody Person person) {
		this.service.addPerson(person);
	}
}


