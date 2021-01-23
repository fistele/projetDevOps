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

import tn.iit.dto.MedicalFileDTO;
import tn.iit.service.MedicalFileService;

@RestController
@RequestMapping("/api/medicalfile")
public class MedicalFileController {
    
    @Autowired
    private MedicalFileService medicalFileService;
    

    @GetMapping()
    Collection<MedicalFileDTO> getAll(){
        return medicalFileService.getMedicalFileDetails();
    }
    

    @PostMapping()
    ResponseEntity<?> createDossier(@RequestBody MedicalFileDTO medicalFileDto) {
        MedicalFileDTO addedmedicationFile = medicalFileService.save(medicalFileDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addedmedicationFile.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping()
    ResponseEntity<MedicalFileDTO> updateDossier(@PathVariable("id") int id,  
    		@RequestBody MedicalFileDTO medicalFileDto) {
    	medicalFileDto.setId(id);  
        MedicalFileDTO result = medicalFileService.update(medicalFileDto);
        return ResponseEntity.ok().body(result);    
    }
    
    
    @DeleteMapping()
    ResponseEntity<?> deleteDossier( @PathVariable("id") int id) {
        medicalFileService.delete(id);
        return ResponseEntity.ok().body("MedicationFile with ID : "+id+" deleted with success!");  
    }
}
