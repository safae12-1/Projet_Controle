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

import com.example.demo.entities.Employe;
import com.example.demo.services.EmployeService;

@RestController
@RequestMapping("api/v1/Employe")
public class EmployeController {

	@Autowired
	EmployeService  employeService;
	@GetMapping
	public List<Employe> findAllemploye(){
		return employeService.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> findemployeById(@PathVariable Long id) {
		Employe employe =employeService.findById(id);
		if(employe==null) {
			return new ResponseEntity<Object>("employe avec id "+id+" n'existe pas ",HttpStatus.BAD_REQUEST);
		}
		else {
			return ResponseEntity.ok(employe);
		}
	}
	
	@PostMapping
	public Employe createemploye(@RequestBody Employe employe) {
		employe.setId(0L);
		return employeService.create(employe);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateemploye(@PathVariable Long id,@RequestBody Employe employe) {
		if(employeService.findById(id)==null) {
			return new ResponseEntity<Object>("employe avec id "+id+" n'existe pas ",HttpStatus.BAD_REQUEST);
		}
		else {
			employe.setId(id);
			employeService.update(employe);
			return ResponseEntity.ok("mise a jour avec succes");

		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteemploye(@PathVariable Long id) {
		Employe employe =employeService.findById(id);
		if(employe==null) {
			return new ResponseEntity<Object>("employe avec id "+id+" n'existe pas",HttpStatus.BAD_REQUEST);
		}
		else {
			employeService.delete(employe);
			return ResponseEntity.ok("employe a été bien supprimé");
		}
		
	}
}
