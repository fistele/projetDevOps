package tn.iit.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.iit.dto.MedicationFileDetailsDTO;
import tn.iit.service.MedicalFileDetailsService;

@RestController
@RequestMapping("/api/medicalfiledetail")
public class MedicalFileDetailsController {
    
    @Autowired
    private MedicalFileDetailsService medicalFileDetailsService;
    
    @GetMapping()
    Collection<MedicationFileDetailsDTO> getAll(){
        return medicalFileDetailsService.getAllMedicalFileDetails();
    }
    

    @PostMapping()
    ResponseEntity<?> createDossierDetails(
    		@RequestBody MedicationFileDetailsDTO medicalFileDetail) {
        MedicationFileDetailsDTO addedMedicalFile = medicalFileDetailsService.save(medicalFileDetail);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addedMedicalFile.getId_medicalFiledetails())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping()
    ResponseEntity<MedicationFileDetailsDTO> updateDossierDetails(
    		@PathVariable("id") int id,  
    		@RequestBody MedicationFileDetailsDTO medicalFileDetailDto) {
    	medicalFileDetailDto.setId_medicalFiledetails(id);
    	MedicationFileDetailsDTO result = medicalFileDetailsService.update(medicalFileDetailDto);
        return ResponseEntity.ok().body(result);    
    }
    
    
    @DeleteMapping()
    ResponseEntity<?> deleteDossierDetails( @PathVariable("id") int id) {
        medicalFileDetailsService.delete(id);
        return ResponseEntity.ok().body("MedicationFile Details with ID : "+id+" deleted with success!");  
    }
}
