package com.palindrom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palindrom.model.Demo;

@Repository
public interface DemoRepository extends CrudRepository<Demo, Long>{

	Demo findByName(String input);

}
