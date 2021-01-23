package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entity.MedicationFileDetails;


public interface MedicalFileDetailsRepository  
	extends JpaRepository<MedicationFileDetails, Integer> {
	 MedicationFileDetails findById(int id);
}
