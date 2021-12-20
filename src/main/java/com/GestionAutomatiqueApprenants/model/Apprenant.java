package com.GestionAutomatiqueApprenants.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Apprenant extends AbstractEntity{
	private String nom;
	private String prenom;
	@Email
	private String email;
	private Long telephone;
	private Adresse adresse;

}
