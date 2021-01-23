package tn.iit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "dossierDetails")
@EntityListeners(AuditingEntityListener.class)
public class MedicationFileDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_MedicationFiledetails;
    private int medicationId;
    private int amount;
    private float prize;
    private LocalDateTime date;
    
    @ManyToOne()
	public MedicationFile medicationFile;

    
	public int getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrize() {
		return prize;
	}
	public void setPrize(float prize) {
		this.prize = prize;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public MedicationFile getDossier() {
		return medicationFile;
	}
	public void setDossier(MedicationFile medicationFile) {
		this.medicationFile = medicationFile;
	}
	public MedicationFileDetails() {
		super();
	}
    
}