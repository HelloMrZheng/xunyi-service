package com.helpu.generic.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.helpu.generic.persistence.repository.BaseRepository;

public class BaseService<T> extends BaseRepository<T> {

	@Autowired(required=false)
	protected BaseRepository<T> repository;
	
	public void save(Object targetObject) {
		repository.save(targetObject);
	}
	
}
