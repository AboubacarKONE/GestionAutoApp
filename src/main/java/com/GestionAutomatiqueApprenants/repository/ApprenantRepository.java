package com.GestionAutomatiqueApprenants.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.GestionAutomatiqueApprenants.model.Apprenant;
@RepositoryRestResource
@CrossOrigin("*")
public interface ApprenantRepository extends JpaRepository<Apprenant, Integer>{
	Optional<Apprenant> findByEmail(String email);

}
