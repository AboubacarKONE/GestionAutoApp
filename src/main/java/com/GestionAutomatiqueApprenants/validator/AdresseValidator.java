package com.GestionAutomatiqueApprenants.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.GestionAutomatiqueApprenants.model.Adresse;



public class AdresseValidator {
	public static List<String>validator(Adresse adresse){
		List<String>errors = new ArrayList<String>();
		if(adresse==null) {
			errors.add("Veuillez renseigner l'adresse 1");
			errors.add("Veuillez renseigner la ville");
			errors.add("Veuillez renseigner le pays");
			return errors;
		}
		if(!StringUtils.hasLength(adresse.getAdresse1())) {
			errors.add("Veuillez renseigner l'adresse 1");
		}
		if(!StringUtils.hasLength(adresse.getVille())) {
			errors.add("Veuillez renseigner la ville");
		}
		if(!StringUtils.hasLength(adresse.getPays())) {
			errors.add("Veuillez renseigner le pays");
		}
		return errors;
	}

}
