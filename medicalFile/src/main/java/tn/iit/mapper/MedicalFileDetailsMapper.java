package tn.iit.mapper;

import java.util.ArrayList;
import java.util.Collection;

import tn.iit.dto.MedicationFileDetailsDTO;
import tn.iit.entity.MedicationFileDetails;



public class MedicalFileDetailsMapper {
	public static  MedicationFileDetails DtoToEntity( MedicationFileDetailsDTO medicationFileDetailsDto) {
		 MedicationFileDetails medicationFile = new  MedicationFileDetails();
		 medicationFileDetailsDto.setMedicationId(medicationFileDetailsDto.getMedicationId());
		 medicationFileDetailsDto.setId_medicalFiledetails(medicationFileDetailsDto.getId_medicalFiledetails());
		 medicationFileDetailsDto.setAmount(medicationFileDetailsDto.getAmount());
		 medicationFileDetailsDto.setPrice(medicationFileDetailsDto.getPrice());
		 medicationFileDetailsDto.setDate(medicationFileDetailsDto.getDate());
       return medicationFile ;
	}
	
	   public static MedicationFileDetailsDTO EntityToDto(MedicationFileDetails medicalFile) {
		   MedicationFileDetailsDTO medicationFileDetailsDTO = new MedicationFileDetailsDTO();
		   medicationFileDetailsDTO.setId_medicalFiledetails(medicalFile.getMedicationId());
		   medicationFileDetailsDTO.setMedicationId(medicalFile.getMedicationId());
		   medicationFileDetailsDTO.setAmount(medicalFile.getAmount());
		   medicationFileDetailsDTO.setPrice(medicalFile.getPrize());
		   medicationFileDetailsDTO.setDate(medicalFile.getDate());
		   //dossierDetailsDTO.setDossier(dos.getDossier());
          return medicationFileDetailsDTO;                            
      }
	   
	   public static Collection<MedicationFileDetailsDTO> EntityToDtos(Collection<MedicationFileDetails> doss) {
		   Collection<MedicationFileDetailsDTO> dosdets = new ArrayList<>();
		   doss.forEach(dos -> {
			   dosdets.add(EntityToDto(dos));
		   });
           return dosdets;                            
       }
}
