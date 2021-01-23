package tn.iit.mapper;


import java.util.ArrayList;
import java.util.Collection;

import tn.iit.dto.MedicationDTO;
import tn.iit.entity.Medication;

public class MedicationMapper {
	public static Medication MedicationDtoToMedication(MedicationDTO medicationDto) {
		Medication medication = new Medication();
		medication.setId(medicationDto.getId());
		medication.setDescription(medicationDto.getDescription());
        return medication ;
	}
	
	   public static MedicationDTO MedicationToMedicationDto(Medication medication) {
		   MedicationDTO medicationDto = new MedicationDTO();
		   medicationDto.setId(medication.getId());
		   medicationDto.setDescription(medication.getDescription());
           return medicationDto;                            
       }
	   
	   public static Collection<MedicationDTO> MedicationsToMedicationDtos(Collection<Medication> medications) {
		   Collection<MedicationDTO> medicationDtos = new ArrayList<>();
		   medications.forEach(medication -> {
			   medicationDtos.add(MedicationToMedicationDto(medication));
		   });
           return medicationDtos;                            
       }
	   
}
