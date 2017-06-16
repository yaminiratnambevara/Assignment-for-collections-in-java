package com.psl.bean;

import java.io.Serializable;
import java.util.Set;

public class Hospital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1320852801512120278L;
	private int hospitalId;
	private int bedCount;
	private Set<Doctor> set = null;
	private String hospitalName;

	
	
	
	

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", bedCount=" + bedCount
				+ ", set=" + set + ", hospitalName=" + hospitalName + "]";
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public Set<Doctor> getSet() {
		return set;
	}

	public void setSet(Set<Doctor> set) {
		this.set = set;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
