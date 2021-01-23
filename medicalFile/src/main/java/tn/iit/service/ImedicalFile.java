package tn.iit.service;

import java.util.Collection;
import tn.iit.dto.MedicalFileDTO;

public interface ImedicalFile {
	MedicalFileDTO findById(int id);
	MedicalFileDTO save(MedicalFileDTO dos);
    MedicalFileDTO update(MedicalFileDTO dos);
    void delete(int id);
	Collection<MedicalFileDTO> getMedicalFileDetails();
}
