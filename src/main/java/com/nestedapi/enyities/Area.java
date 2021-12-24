package com.nestedapi.enyities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area_information")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int areaCode ;
	private String areaName ;
	private String areaPopulation ;
	
	public Area(int areaCode, String areaName, String areaPopulation) {
		super();
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.areaPopulation = areaPopulation;
	}

	public Area() {
		
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaPopulation() {
		return areaPopulation;
	}

	public void setAreaPopulation(String areaPopulation) {
		this.areaPopulation = areaPopulation;
	}

	@Override
	public String toString() {
		return "Area [areaCode=" + areaCode + ", areaName=" + areaName + ", areaPopulation=" + areaPopulation + "]";
	}
	
	
	
	

}
