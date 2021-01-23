package tn.iit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "medicationFile")
@EntityListeners(AuditingEntityListener.class)
public class MedicationFile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_medicationFile;
    private String patient;
    
    @JsonIgnore
    @OneToMany(mappedBy = "medicationFile", 
    cascade = CascadeType.REMOVE,
    fetch = FetchType.EAGER)
    public List<MedicationFileDetails> medicationFiledetails;
    
	
	
	public int getId_medicationFile() {
		return id_medicationFile;
	}



	public void setId_medicationFile(int id_medicationFile) {
		this.id_medicationFile = id_medicationFile;
	}



	public String getPatient() {
		return patient;
	}



	public void setPatient(String patient) {
		this.patient = patient;
	}



	public List<MedicationFileDetails> getMedicationFiledetails() {
		return medicationFiledetails;
	}



	public void setMedicationFiledetails(List<MedicationFileDetails> medicationFiledetails) {
		this.medicationFiledetails = medicationFiledetails;
	}



	public MedicationFile() {
		super();
	}
    
	
    
    
}