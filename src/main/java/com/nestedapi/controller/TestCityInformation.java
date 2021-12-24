package com.nestedapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nestedapi.enyities.CityInformation;
import com.nestedapi.service.CityService;

@RestController
public class TestCityInformation {

	@Autowired
	private CityService cityService;

	@GetMapping("/city")
	public ResponseEntity<List<CityInformation>> getCity() {

		List<CityInformation> list = this.cityService.getAllCityInfo();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	}

	@GetMapping("/city/{cityCode}")
	public ResponseEntity<CityInformation> getOneCity(@PathVariable("cityCode") int cityCode) {

		CityInformation city = this.cityService.getOneCityInfo(cityCode);

		if (city == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(city));
		}
	}

	@PostMapping("/city")
	public ResponseEntity<CityInformation> addCityInfo(@RequestBody CityInformation city) {

		CityInformation addCity = null;
		try {
			addCity = this.cityService.addCity(city);
			return ResponseEntity.of(Optional.of(addCity));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/city/{cityCode}")
	public ResponseEntity<Void> delete(@PathVariable("cityCode") int cityCode) {
		try {
			this.cityService.deleteCity(cityCode);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("city/{cityCode}")
	public ResponseEntity<CityInformation> updateCity(@RequestBody CityInformation cityIn,
			@PathVariable("cityCode") int cityCode) {

		try {
			this.cityService.updateCity(cityIn, cityCode);
			return ResponseEntity.ok().body(cityIn);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
