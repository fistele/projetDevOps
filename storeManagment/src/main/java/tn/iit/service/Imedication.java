package tn.iit.service;

import java.util.Collection;
import tn.iit.dto.MedicationDTO;

public interface Imedication {
	Collection<MedicationDTO> getAllMedications();
	MedicationDTO findById(int id);
    MedicationDTO save(MedicationDTO medication);
    MedicationDTO update(MedicationDTO medication);
    void delete(int id);
}
