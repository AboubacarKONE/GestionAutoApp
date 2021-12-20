package com.GestionAutomatiqueApprenants.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.GestionAutomatiqueApprenants.model.Apprenant;

public class ApprenantValidator {
	public static List<String>validator(Apprenant app){
		List<String>errors = new ArrayList<String>();
		if(app==null) {
			errors.add("Veuillez renseigner le nom");
			errors.add("Veuillez renseigner le prenom");
			errors.add("Veuillez renseigne l'email");
			errors.add("Veuillez renseigner le numero de telephone");
			return errors;
		}
		if(!StringUtils.hasLength(app.getNom())) {
			errors.add("Veuillez renseigner le nom ");
		}
		if(!StringUtils.hasLength(app.getPrenom())) {
			errors.add("Veuillez renseigner le prenom");
		}
		if(!StringUtils.hasLength(app.getEmail())) {
			errors.add("Veuillez renseigne l'email");
		}
		if(app.getTelephone()==null) {
			errors.add("Veuillez renseigner le numero de telephone");
		}
		errors.addAll(AdresseValidator.validator(app.getAdresse()));
		return errors;
	}

}
