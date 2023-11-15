package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Service;

import com.example.demo.services.ServiceService;


@RestController
@RequestMapping("api/v1/Service")
public class ServiceController {


	@Autowired
	ServiceService  ServiceService;
	@GetMapping
	public List<Service> findAllService(){
		return ServiceService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> findServiceById(@PathVariable Long id) {
		Service Service =ServiceService.findById(id);
		if(Service==null) {
			return new ResponseEntity<Object>("Service avec id "+id+" n'existe pas ",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(Service);
		}
	}
	
	@PostMapping
	public Service createService(@RequestBody Service Service) {
		Service.setId(0L);
		return ServiceService.create(Service);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable Long id,@RequestBody Service Service) {
		if(ServiceService.findById(id)==null) {
			return new ResponseEntity<Object>("Service avec id "+id+" n'existe pas ",HttpStatus.BAD_REQUEST);
		}
		else {
			Service.setId(id);
			ServiceService.update(Service);
			return ResponseEntity.ok("mise a jour avec succes");

		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteService(@PathVariable Long id) {
		Service Service =ServiceService.findById(id);
		if(Service==null) {
			return new ResponseEntity<Object>("Service avec id "+id+" n'existe pas",HttpStatus.BAD_REQUEST);
		}
		else {
			ServiceService.delete(Service);
			return ResponseEntity.ok("Service a été bien supprimé");
		}
		
	}
}
