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
import tn.iit.dto.MedicationDTO;
import tn.iit.service.MedicationService;

@RestController
@RequestMapping("/api/medication")
public class MedicationController {
    
    @Autowired
    private MedicationService medicationService;
    

    @GetMapping()
    Collection<MedicationDTO> getAll(){
        return medicationService.getAllMedications();
    }
    

    @PostMapping()
    ResponseEntity<?> createArticle(@RequestBody MedicationDTO medicationDto) {
        MedicationDTO addedmedication = medicationService.save(medicationDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addedmedication.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping()
    ResponseEntity<MedicationDTO> updateArticle(@PathVariable("id") int id,  
    		@RequestBody MedicationDTO medicationDto) {
    	medicationDto.setId(id);
    	MedicationDTO result = medicationService.update(medicationDto);
        return ResponseEntity.ok().body(result);    
    }
    
    
    @DeleteMapping()
    ResponseEntity<?> deleteArticle( @PathVariable("id") int id) {
        medicationService.delete(id);
        return ResponseEntity.ok().body("Medication with ID : "+id+" deleted with success!");  
    }
}
