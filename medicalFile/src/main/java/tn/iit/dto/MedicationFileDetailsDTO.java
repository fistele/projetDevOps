package tn.iit.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class MedicationFileDetailsDTO {
    private int id_medicalFiledetails;
    private String descriptionmedication;
    private Integer medicationId;
    private int amount;
    private float price;
    private LocalDateTime date;
	public int getId_medicalFiledetails() {
		return id_medicalFiledetails;
	}
	public void setId_medicalFiledetails(int id_medicalFiledetails) {
		this.id_medicalFiledetails = id_medicalFiledetails;
	}
	public String getDescriptionmedication() {
		return descriptionmedication;
	}
	public void setDescriptionmedication(String descriptionmedication) {
		this.descriptionmedication = descriptionmedication;
	}
	public Integer getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
    
  
}
