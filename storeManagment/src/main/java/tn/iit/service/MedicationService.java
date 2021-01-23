package tn.iit.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.dao.MedicationRepository;
import tn.iit.dto.MedicationDTO;
import tn.iit.entity.Medication;
import tn.iit.mapper.MedicationMapper;

@Service
public class MedicationService implements Imedication {
    @Autowired
    private MedicationRepository medicationRepository;
    
    @Override
    public Collection<MedicationDTO> getAllMedications() {
        return MedicationMapper.MedicationsToMedicationDtos(
        		medicationRepository.findAll()
        		);
    }
    
    @Override
    public MedicationDTO findById(int id) {
    	Medication medication = medicationRepository.findById(id);
    	MedicationDTO resultDTO = MedicationMapper.MedicationToMedicationDto(medication);
        return resultDTO;
        }
    
    @Override
    public MedicationDTO save(MedicationDTO medicationDto) {
        Medication medication = MedicationMapper.MedicationDtoToMedication(medicationDto);
        medication =  medicationRepository.save(medication);
        MedicationDTO resultDTO = MedicationMapper.MedicationToMedicationDto(medication);
        return resultDTO;
    }
    
    @Override
    public void delete(int id) {
        medicationRepository.deleteById(id);
    }
    
	@Override
	public MedicationDTO update(MedicationDTO medicationDto) {
		Medication medication = MedicationMapper.MedicationDtoToMedication(medicationDto);
        medication =  medicationRepository.save(medication);
        MedicationDTO resultDTO = MedicationMapper.MedicationToMedicationDto(medication);
        return resultDTO;
	}
}