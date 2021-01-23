package tn.iit.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.MedicalFileDetailsRepository;
import tn.iit.dto.MedicationFileDetailsDTO;
import tn.iit.entity.MedicationFileDetails;
import tn.iit.mapper.MedicalFileDetailsMapper;


@Service
public class MedicalFileDetailsService implements ImedicalFileDetails {
	
    @Autowired
    private MedicalFileDetailsRepository medicalFileDetailsRepository;
    
    @Override
    public Collection<MedicationFileDetailsDTO> getAllMedicalFileDetails() {
        return MedicalFileDetailsMapper.EntityToDtos(medicalFileDetailsRepository.findAll());
    }
    
    @Override
    public MedicationFileDetailsDTO findById(int id) {
    	MedicationFileDetails dos = medicalFileDetailsRepository.findById(id);
    	MedicationFileDetailsDTO resultDTO = MedicalFileDetailsMapper.EntityToDto(dos);
        return resultDTO;
    }
    
    @Override
    public MedicationFileDetailsDTO save(MedicationFileDetailsDTO dosdto) {
    	MedicationFileDetails dos = MedicalFileDetailsMapper.DtoToEntity(dosdto);
        dos =  medicalFileDetailsRepository.save(dos);
      	MedicationFileDetailsDTO resultDTO = MedicalFileDetailsMapper.EntityToDto(dos);
        return resultDTO;    
    }
    
    @Override
    public void delete(int id) {
    	medicalFileDetailsRepository.deleteById(id);
    }
    
    
    @Override
	public MedicationFileDetailsDTO update(MedicationFileDetailsDTO dosdto) {
    	MedicationFileDetails dos = MedicalFileDetailsMapper.DtoToEntity(dosdto);
        dos =  medicalFileDetailsRepository.save(dos);
      	MedicationFileDetailsDTO resultDTO = MedicalFileDetailsMapper.EntityToDto(dos);
        return resultDTO;
	}
}