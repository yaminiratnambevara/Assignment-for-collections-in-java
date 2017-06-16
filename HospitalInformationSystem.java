package com.psl.util;

import java.util.List;
import java.util.Set;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;

public interface HospitalInformationSystem {
	Set<Hospital> readAllHospital(String fileHospital,String fileDoctor);
	Set<Doctor> getListOfDoctors(Set<Hospital> treeSet);//this will return a list of doctors more than 1000 days of experience without repetition
	List<Doctor> eligibleForAppointment(Set<Hospital> treeSet,Speciality speciality,int experienceInDays);//create list of doctor according to experience and specialization without experience
	List<Doctor> getListWithinHospital(Set<Hospital> treeSet,int hospitalId,Speciality speciality,int experience);
	
}
