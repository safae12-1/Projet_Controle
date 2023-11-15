package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDao;
import com.example.demo.entities.Employe;
import com.example.demo.repository.EmployeRepository;

@Service
public class EmployeService implements IDao<Employe>{
    @Autowired
    private EmployeRepository EmployeRepository;
	@Override
	public Employe create(Employe o) {
		return EmployeRepository.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		try {
			EmployeRepository.delete(o);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Employe update(Employe o) {
		return EmployeRepository.save(o);
	}

	@Override
	public List<Employe> findAll() {
		return EmployeRepository.findAll();
	}

	@Override
	public Employe findById(Long id) {
		return EmployeRepository.findById(id).orElse(null);
	}
}
