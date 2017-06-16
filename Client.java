package com.psl.main;

import java.util.List;
import java.util.Set;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;
import com.psl.util.HospitalInformationSystemImpl;

public class Client {

	public static void main(String[] args) {
		
		HospitalInformationSystemImpl impl=new HospitalInformationSystemImpl();
		Set<Hospital> set=impl.readAllHospital("hospital.ser","doctor.ser");
		System.out.println("\n\n\n\n\n");
	for (Hospital hospital : set) {
			System.out.println(hospital);
		}
		
		
		System.out.println("\n\n\n\n\n");
		Set<Doctor> doctors=impl.getListOfDoctors(set);
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}
		
		
		System.out.println("\n\n\n\n\n");
		List<Doctor> list=impl.getListWithinHospital(set,2013,Speciality.Garnacologist,1000);
		for (Doctor doctor : list) {
			System.out.println(doctor.getSpeciality()+"\t"+doctor.getExperience());
		}
		
		System.out.println("\n\n\n\n\n");
		List<Doctor> list1=impl.eligibleForAppointment(set,Speciality.Garnacologist,1000);
		for (Doctor doctor : list1) {
			System.out.println(doctor.getDoctorId()+"\t"+doctor.getHospitalId()+"\t"+doctor.getSpeciality()+"\t"+doctor.getExperience());
		}
		
		
		
		
	}
}

