package com.nestedapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.nestedapi.enyities.CityInformation;

public interface CityReposetory extends CrudRepository<CityInformation, Integer>{

	public CityInformation findById(int id);
}
