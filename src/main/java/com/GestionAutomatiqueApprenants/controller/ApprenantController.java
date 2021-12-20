package com.GestionAutomatiqueApprenants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GestionAutomatiqueApprenants.model.Apprenant;
import com.GestionAutomatiqueApprenants.service.ApprenantService;

@RestController
@RequestMapping("/odc")
@CrossOrigin("*")
public class ApprenantController {
	private ApprenantService apprenantService;
	@Autowired
	public ApprenantController( ApprenantService apprenantService) {
		this.apprenantService = apprenantService;
	}
	@PostMapping(value="/saveApprenant")
	Apprenant save(@RequestBody Apprenant apprenant) {
		return apprenantService.save(apprenant);
	}
	@PutMapping(value="/updateApprenant/{id}")
	Apprenant update(@PathVariable Integer id,@RequestBody Apprenant apprenant) {
		return apprenantService.update( id, apprenant);
	}
	@GetMapping(value="/ApprenantById/{id}")
	Apprenant findApprenantById(@PathVariable Integer id) {
		return apprenantService.findApprenantById(id);
	}
	@GetMapping(value="/listeApprenants")
	List<Apprenant>findAllApprenant(){
		return apprenantService.findAllApprenant();
	}
	@GetMapping("/listeByGroupe/nbreApprenant={apprenant}&nbreGroupe={groupe}")
	List<Apprenant>findApprenantByGroupe(int nombreApprenant, int nombreGroupe){
		return apprenantService.findApprenantByGroupe(nombreApprenant, nombreGroupe);
	}
	@DeleteMapping
	void delete(Integer id) {
		apprenantService.delete(id);
	}


}
