package com.psl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;

public class HospitalInformationSystemImpl implements HospitalInformationSystem {

	@Override
	public Set<Hospital> readAllHospital(String fileHospital, String fileDoctor) {
		
		Set<Hospital> returnSet=new TreeSet<Hospital>(new Comparator<Hospital>() {

			@Override
			public int compare(Hospital h1, Hospital h2) {
				return h1.getHospitalId()-h2.getHospitalId();
			}
		});
		
		ObjectInputStream inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream(new File(fileHospital)));
			while (true) {
				returnSet.add((Hospital)inputStream.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		List<Doctor> listDoctor=new ArrayList<Doctor>();
		try {
			inputStream=new ObjectInputStream(new FileInputStream(new File(fileDoctor)));
			while (true) {
				listDoctor.add((Doctor)inputStream.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		for (Doctor doctor : listDoctor) {
			System.out.println(doctor);
		}
		
		
		for (Hospital hospital : returnSet) {
			hospital.setSet(new TreeSet<Doctor>(new Comparator<Doctor>() {

				@Override
				public int compare(Doctor d1, Doctor d2) {
					
					return d1.getDoctorId()-d2.getDoctorId();
				}
			}));
			
		}
		
		for (Hospital hospital : returnSet) {
			for (Doctor doctor : listDoctor) {
				if(hospital.getHospitalId()==doctor.getHospitalId()){
					hospital.getSet().add(doctor);
				}
			}
		}
		
		
		return returnSet;
	}

	@Override
	public Set<Doctor> getListOfDoctors(Set<Hospital> treeSet) {
		
		Set<Doctor> returnSet=new HashSet<Doctor>();
		List<Doctor>  list=new ArrayList<Doctor>();
		long current=Calendar.getInstance().getTimeInMillis();
		for (Hospital hospital : treeSet) {
			list.addAll(hospital.getSet());
		}
		
		
		for (Doctor doctor : list) {
			long given=doctor.getJoiningDate().getTime();
			int numberOfDays=(int)((current-given)/(24*60*60*1000));
			doctor.setExperience(numberOfDays);
		}
//		System.out.println(list.size());
		Iterator<Doctor> iterator=list.iterator();
		while (iterator.hasNext()) {
			Doctor doctor=iterator.next();
			if(doctor.getExperience()<1000){
				iterator.remove();
			}
		}
		
		returnSet.addAll(list);
//		System.out.println(returnSet.size());
//		System.out.println(list.size());
//		for (Doctor doctor : list) {
//			System.out.println(doctor.getDoctorId()+"\t"+doctor.getExperience());
//		}
		
		return returnSet;
	}

	@Override
	public List<Doctor> eligibleForAppointment(Set<Hospital> treeSet,Speciality speciality, int experienceInDays) {
		
		List<Doctor> returnList=new ArrayList<Doctor>();
		for (Hospital hospital : treeSet) {
			returnList.addAll(hospital.getSet());	
		}
		
		
		Iterator<Doctor> iterator=returnList.iterator();
		while (iterator.hasNext()) {
			Doctor doctor=iterator.next();
			if(doctor.getSpeciality().equals(speciality) && doctor.getExperience()>=1000){
				continue;
			}
			else{
				iterator.remove();
			}
		}
		return returnList;
	}

	@Override
	public List<Doctor> getListWithinHospital(Set<Hospital> treeSet,int hospitalId, Speciality speciality, int experience) {
		Set<Doctor> set=new HashSet<Doctor>();
		for (Hospital hospital : treeSet) {
			if(hospital.getHospitalId()==hospitalId){
				for(Doctor doctor:hospital.getSet()){
					if(doctor.getSpeciality().equals(speciality) && doctor.getExperience()>=experience){
						set.add(doctor);
					}
				}
			}
		}
		
		List<Doctor> list=new ArrayList<Doctor>();
		list.addAll(set);
		
		return list;
	}
}
