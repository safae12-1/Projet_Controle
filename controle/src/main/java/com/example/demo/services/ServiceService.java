package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.dao.IDao;
import com.example.demo.entities.Service;

import com.example.demo.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {
    @Autowired
    private ServiceRepository ServiceRepository;
	@Override
	public Service create(Service o) {
		return ServiceRepository.save(o);
	}

	@Override
	public boolean delete(Service o) {
		try {
			ServiceRepository.delete(o);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Service update(Service o) {
		return ServiceRepository.save(o);
	}

	@Override
	public List<Service> findAll() {
		return ServiceRepository.findAll();
	}

	@Override
	public Service findById(Long id) {
		return ServiceRepository.findById(id).orElse(null);
	}
}
