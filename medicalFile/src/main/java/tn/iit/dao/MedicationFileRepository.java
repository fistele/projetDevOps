package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.iit.entity.MedicationFile;


public interface MedicationFileRepository 
	extends JpaRepository<MedicationFile, Integer> {
	 MedicationFile findById(int id);

}
