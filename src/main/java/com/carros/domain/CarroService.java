package com.carros.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.carros.domain.dto.CarroDTO;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository rep;
	
	public List<CarroDTO> getCarros() {
		
		return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
		
	}
		
	public Optional<CarroDTO> getCarroById(Long id) {
		return rep.findById(id).map(CarroDTO::create);
	}
	
	public List<CarroDTO> getCarrosByTipo(String tipo) {
		return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
	}
	
	public Carro save(Carro carro) {
		return rep.save(carro);
	}
	
	public void delete(Long id) {
		if(getCarroById(id).isPresent()) {
			rep.deleteById(id);
		}	
	}
}