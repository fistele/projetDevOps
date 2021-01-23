package tn.iit.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class MedicalFileDTO {
	private int id;
    private String patient;
    private List<MedicationFileDetailsDTO> MedicalFiledetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public List<MedicationFileDetailsDTO> getMedicalFiledetails() {
		return MedicalFiledetails;
	}
	public void setMedicalFiledetails(List<MedicationFileDetailsDTO> medicalFiledetails) {
		MedicalFiledetails = medicalFiledetails;
	}
    
    
}