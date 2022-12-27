package com.kwo.pointageActivity.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kwo.pointageActivity.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer>{}
