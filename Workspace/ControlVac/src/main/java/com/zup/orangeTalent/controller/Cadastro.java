package com.zup.orangeTalent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.orangeTalent.model.UserModel;
import com.zup.orangeTalent.model.VacModel;
import com.zup.orangeTalent.repository.UserRepository;
import com.zup.orangeTalent.repository.VacRepository;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin("*")
public class Cadastro {

	@Autowired
	private VacRepository aplyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public ResponseEntity<UserModel> registro(@RequestBody UserModel usuario) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(usuario));	
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().build();

		}
		
	}
	
	@PostMapping("/apply-vac")
	public ResponseEntity<VacModel> cadastro(@RequestBody VacModel vacina) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(aplyRepository.save(vacina));	
		}
		catch (Exception er) {
			return ResponseEntity.badRequest().build();

		}
	}
}
