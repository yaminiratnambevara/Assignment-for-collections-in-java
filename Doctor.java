package com.psl.bean;

import java.io.Serializable;
import java.sql.Date;

public class Doctor implements Serializable {

	
	private static final long serialVersionUID = 2700192949117685712L;
	private int doctorId;
	private String doctorName;
	private int hospitalId;
	private Date joiningDate;
	private Speciality speciality;
	private int experience;

	
	
	
	
	@Override
	public boolean equals(Object arg0) {
		
		if(arg0 instanceof Doctor){
			Doctor doctor=(Doctor)arg0;
			return this.doctorName.equals(doctor.getDoctorName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		
		return this.doctorName.hashCode();
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName
				+ ", hospitalId=" + hospitalId + ", joiningDate=" + joiningDate
				+ ", speciality=" + speciality + ", experience=" + experience
				+ "]";
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

}
