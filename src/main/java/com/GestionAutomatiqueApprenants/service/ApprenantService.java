package com.GestionAutomatiqueApprenants.service;

import java.util.List;

import com.GestionAutomatiqueApprenants.model.Apprenant;

public interface ApprenantService {
	Apprenant save(Apprenant apprenant);
	Apprenant update(Integer id, Apprenant apprenant);
	Apprenant findApprenantById(Integer id);
	List<Apprenant>findAllApprenant();
	List<Apprenant>findApprenantByGroupe(int nombreApprenant, int nombreGroupe);
	void delete(Integer id);
	Apprenant findByEmail(String email);

}
