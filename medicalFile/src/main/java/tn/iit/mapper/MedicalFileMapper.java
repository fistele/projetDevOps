package tn.iit.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import tn.iit.dto.MedicalFileDTO;
import tn.iit.dto.MedicationFileDetailsDTO;
import tn.iit.entity.MedicationFile;
import tn.iit.entity.MedicationFileDetails;

public class MedicalFileMapper {
	
	public static  MedicationFile DtoToEntity(MedicalFileDTO medicalFileDTO) {
		 MedicationFile medicationFile = new  MedicationFile();
		 medicationFile.setId_medicationFile(medicalFileDTO.getId());
		 medicationFile.setPatient(medicalFileDTO.getPatient());
		 medicationFile.setMedicationFiledetails(medicalFileDTO.getMedicalFiledetails().stream().map(dos ->{
			 MedicationFileDetails dosdet = dossierdetailsDtoToEntity(dos);
			 dosdet.setDossier(medicationFile);
		     return dosdet ;
		 }).collect(Collectors.toList())
		);
		 return medicationFile;
	}
	
	   public static MedicalFileDTO EntityToDto(MedicationFile medicalFile) {
		   MedicalFileDTO medicalFileDTO = new MedicalFileDTO();
		   medicalFileDTO.setId(medicalFile.getId_medicationFile());
		   medicalFileDTO.setPatient(medicalFile.getPatient());
		   medicalFileDTO.setMedicalFiledetails(MedicalFiledetailsEntityToDto(medicalFile.getMedicationFiledetails()));
           return medicalFileDTO;                            
       }
	   
	   
	   public static Collection<MedicalFileDTO> EntityToDtos(Collection<MedicationFile> medicalFile) {
		   List<MedicalFileDTO> medicalFileDetails = new ArrayList<>();
		   medicalFile.forEach(dos -> {
			   medicalFileDetails.add(EntityToDto(dos));
		   });
           return medicalFileDetails;                            
       }
	   
	   
	   public static List<MedicationFileDetailsDTO> MedicalFiledetailsEntityToDto(List<MedicationFileDetails> medicationFile) {
		   List<MedicationFileDetailsDTO> medicalFileDetails = new ArrayList<>();
		   medicationFile.forEach(dos -> {
			   medicalFileDetails.add(EntityToDtodosdet(dos));
		   });
           return medicalFileDetails;                            
       }
	   
	   public static MedicationFileDetailsDTO EntityToDtodosdet(MedicationFileDetails medicalFileDetails) {
		   MedicationFileDetailsDTO medicationFileDetailsDTO = new MedicationFileDetailsDTO();
		   medicationFileDetailsDTO.setId_medicalFiledetails(medicalFileDetails.getMedicationId()); 
		   medicationFileDetailsDTO.setMedicationId(medicalFileDetails.getMedicationId());
		   medicationFileDetailsDTO.setAmount(medicalFileDetails.getAmount());
		   medicationFileDetailsDTO.setPrice(medicalFileDetails.getPrize());
		   medicationFileDetailsDTO.setDate(medicalFileDetails.getDate());
		   //dossierDetailsDTO.setDossier(dos.getDossier());
          return medicationFileDetailsDTO;                            
      }
	   
	   public static  MedicationFileDetails dossierdetailsDtoToEntity(MedicationFileDetailsDTO medicationFile) {
			 MedicationFileDetails dossier = new  MedicationFileDetails();
			 dossier.setMedicationId(medicationFile.getId_medicalFiledetails());
			 dossier.setMedicationId(medicationFile.getMedicationId());
			 dossier.setAmount(medicationFile.getAmount());
			 dossier.setPrize(medicationFile.getPrice());
			 dossier.setDate(medicationFile.getDate());
			 //medicationFile.setDossier(dos.getDossier());
	       return dossier ;
		}
	   
	   
}
