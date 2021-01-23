package tn.iit.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import tn.iit.dto.MedicationDTO;

@Service
public class Client {
	private final RestTemplate restTemplate;
	
	public Client(RestTemplate restTemplate) {this.restTemplate = restTemplate;}
	
	public List<MedicationDTO> getAllMedicationDTO(){
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8181/api/medication")
				.build().encode();	
		return restTemplate.exchange(uriComponents.toUri(), 
				HttpMethod.GET,
				new HttpEntity(null, new HttpHeaders()), 
				new ParameterizedTypeReference<List<MedicationDTO>>() {}).getBody();		
	}
	
	public MedicationDTO getMedicationById(int id) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://localhost:8181/api/medication")
				.path("/{id}")
				.build()
				.expand(id)
				.encode();
		ResponseEntity<MedicationDTO> service = restTemplate.exchange(uriComponents.toUri(),
				HttpMethod.GET,
				new HttpEntity(null, new HttpHeaders()), 
				MedicationDTO.class);
		return service.getBody();
	}
	
	
}
