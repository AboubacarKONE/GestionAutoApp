package com.GestionAutomatiqueApprenants.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionAutomatiqueApprenants.exceptions.EntityNotFoundException;
import com.GestionAutomatiqueApprenants.exceptions.ErreurCodes;
import com.GestionAutomatiqueApprenants.exceptions.InvalidEntityException;
import com.GestionAutomatiqueApprenants.model.Apprenant;
import com.GestionAutomatiqueApprenants.repository.ApprenantRepository;
import com.GestionAutomatiqueApprenants.service.ApprenantService;
import com.GestionAutomatiqueApprenants.validator.ApprenantValidator;

@Service
public class ApprenantServiceImpl implements ApprenantService {

	private ApprenantRepository apprenantRepository;

	@Autowired
	public ApprenantServiceImpl(ApprenantRepository apprenantRepository) {
		this.apprenantRepository = apprenantRepository;
	}

	@Override
	public Apprenant save(Apprenant apprenant) {
		List<String> errors = ApprenantValidator.validator(apprenant);
		if (!errors.isEmpty()) {
			throw new InvalidEntityException("l'apprenant n'est pas valide", ErreurCodes.APPRENANT_INVALID, errors);
		}
		Optional<Apprenant> appEmail = apprenantRepository.findByEmail(apprenant.getEmail());
		if (appEmail.isPresent()) {
			throw new InvalidEntityException("Un autre apprenant avec cet email existe deja",
					ErreurCodes.APPRENANT_ALLREADY_EXISTE,
					Collections.singletonList("Un autre administrateur avec cet email existe dans la BDD"));
		}
		return apprenantRepository.save(apprenant);
	}

	@Override
	public Apprenant update(Integer id, Apprenant apprenant) {
		List<String> errors = ApprenantValidator.validator(apprenant);
		if (!errors.isEmpty()) {
			throw new InvalidEntityException("l'apprenant n'est pas valide", ErreurCodes.APPRENANT_INVALID, errors);
		}
		Apprenant app = apprenantRepository.findById(id).get();
		app.setNom(apprenant.getNom());
		app.setPrenom(apprenant.getPrenom());
		app.setEmail(apprenant.getEmail());
		app.setTelephone(apprenant.getTelephone());
		app.setAdresse(apprenant.getAdresse());
		return apprenantRepository.save(app);
	}

	@Override
	public List<Apprenant> findAllApprenant() {
		return apprenantRepository.findAll();
	}

	@Override
	public ArrayList<List<Apprenant>> findApprenantByRandomGroupe(int nbreApprenant, int nbreGroupe) {
		List<Apprenant> app = apprenantRepository.findAll();
		validate(nbreApprenant, nbreGroupe);
		ArrayList<List<Apprenant>> Groupe = new ArrayList<List<Apprenant>>();
		Random rnd = new Random();
		for (int i = 1; i <= nbreGroupe; i++) {
			ArrayList<Apprenant> groupe = new ArrayList<>();
			for (int j = 0; j < nbreApprenant; j++) {
				int randomIndex = rnd.nextInt(app.size());
				Apprenant randomElement = app.get(randomIndex);
				groupe.add(randomElement);
				app.remove(randomIndex);
				// System.out.println(app.size());
			}
			Groupe.add(groupe);
			// groupe.removeAll(groupe);
		}
		if (app.size() != 0) {
			for (int i = 0; i < app.size(); i++) {
				int randomIndex = rnd.nextInt(app.size());
				Apprenant randomElement = app.get(randomIndex);
				Groupe.get(i).add(randomElement);
			}
		}

		System.out.println(app.size());

		return Groupe;
	}

	@Override
	public void delete(Integer id) {
		apprenantRepository.deleteById(id);

	}

	@Override
	public Apprenant findApprenantById(Integer id) {
		return apprenantRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun apprenant avec l'id = " + id + " n'a ete trouvé dans la BDD",
						ErreurCodes.APPRENANT_NOT_FOUND));
	}

	@Override
	public Apprenant findByEmail(String email) {
		return apprenantRepository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun apprenant avec l'email " + email + " n'existe dans la BDD",
						ErreurCodes.APPRENANT_NOT_FOUND));
	}

	private void validate(int a, int b) {
		List<Apprenant> app = apprenantRepository.findAll();
		if (a * b > app.size()) {
			throw new InvalidEntityException("le nombre total d'apprenant " + app.size()
					+ " ne vaut le nombre de groupe et d'apprenants " + a * b);
			}
		if(a < 2 || b < 2) {
			throw new InvalidEntityException("veuillez renseigner une valeur valide pour les apprenants et le tableau");
		}
		
	}

}
