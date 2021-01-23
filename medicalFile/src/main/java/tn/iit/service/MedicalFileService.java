package tn.iit.service;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.MedicationFileRepository;
import tn.iit.dto.MedicationDTO;
import tn.iit.dto.MedicalFileDTO;
import tn.iit.entity.MedicationFile;
import tn.iit.exception.RunningException;
import tn.iit.mapper.MedicalFileMapper;


@Service
public class MedicalFileService implements ImedicalFile {

    @Autowired
    private MedicationFileRepository medicationFileRepository;
    @Autowired  
    private Client client;
    
    @Override
    public Collection<MedicalFileDTO> getMedicalFileDetails() {
    	return MedicalFileMapper.EntityToDtos(medicationFileRepository.findAll());
    }
    
    @Override
    public MedicalFileDTO findById(int id) {
    	MedicationFile medicationFile  = medicationFileRepository.findById(id);
    	MedicalFileDTO medicalFileDTO = MedicalFileMapper.EntityToDto(medicationFile);
    	
    	List<MedicationDTO> medicationDTOS = client.getAllMedicationDTO();

    	medicalFileDTO.getMedicalFiledetails().forEach(filedet -> {
    		MedicationDTO medicationDTO = medicationDTOS.stream()
    				.filter(medication -> medication.getId().equals(filedet.getMedicationId()))
    				.findFirst()
    				.orElseThrow(()-> new RunningException("missing article with id : " + filedet.getId_medicalFiledetails()));

    		filedet.setDescriptionmedication(medicationDTO.getDescription());  	

    	});

        return medicalFileDTO;
    }
    
    @Override
    public MedicalFileDTO save(MedicalFileDTO dosdto) {
    	MedicationFile dos = MedicalFileMapper.DtoToEntity(dosdto);
        dos =  medicationFileRepository.save(dos);
      	MedicalFileDTO resultDTO = MedicalFileMapper.EntityToDto(dos);
        return resultDTO; 
    }
    
    @Override
   	public MedicalFileDTO update(MedicalFileDTO dosdto) {
       	MedicationFile dos = MedicalFileMapper.DtoToEntity(dosdto);
           dos =  medicationFileRepository.save(dos);
         	MedicalFileDTO resultDTO = MedicalFileMapper.EntityToDto(dos);
           return resultDTO;
   	}
    
    @Override
    public void delete(int id) {
    	medicationFileRepository.deleteById(id);
    }

}