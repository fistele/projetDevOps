package tn.iit.service;

import java.util.Collection;
import tn.iit.dto.MedicationFileDetailsDTO;

public interface ImedicalFileDetails {
	Collection<MedicationFileDetailsDTO> getAllMedicalFileDetails();
    MedicationFileDetailsDTO findById(int id);
    MedicationFileDetailsDTO save(MedicationFileDetailsDTO dos);
    MedicationFileDetailsDTO update(MedicationFileDetailsDTO dos);
    void delete(int id);
}
