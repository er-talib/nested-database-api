package com.nestedapi.enyities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="city_information")
public class CityInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cityCode ;
	private String cityName ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Area area ;
	
	
	public CityInformation(int cityCode, String cityName, Area area) {
		super();
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.area = area;
	}


	public CityInformation() {
		
	}


	public int getCityCode() {
		return cityCode;
	}


	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "CityInformation [cityCode=" + cityCode + ", cityName=" + cityName + ", cityArea=" + area + "]";
	}
	
	
	
	

}
