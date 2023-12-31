package com.example.demo.dao;

import java.util.List;

public interface IDao  <T>{

	T create (T o);
	boolean  delete(T o);
	T update(T o);
	List<T> findAll();
	T findById (Long id);
	
}
