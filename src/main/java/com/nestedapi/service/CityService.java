package com.nestedapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nestedapi.dao.CityReposetory;
import com.nestedapi.enyities.CityInformation;

@Component
public class CityService {

	@Autowired
	private CityReposetory cityReposetory;

	public List<CityInformation> getAllCityInfo() {
		List<CityInformation> cityInfo = (List<CityInformation>) this.cityReposetory.findAll();
		return cityInfo;
	}

	public CityInformation getOneCityInfo(int code) {

		CityInformation city = null;
		try {
			city = this.cityReposetory.findById(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}

	
	public CityInformation addCity(CityInformation cityInf) {

		CityInformation city = this.cityReposetory.save(cityInf);
		return city;
	}

	
	public void deleteCity(int id) {
		this.cityReposetory.deleteById(id);
	}

	
	public void updateCity(CityInformation cityInfo, int code) {

		cityInfo.setCityCode(code);
		this.cityReposetory.save(cityInfo);
	}
}
