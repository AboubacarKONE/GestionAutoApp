package com.GestionAutomatiqueApprenants.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class Adresse implements Serializable{
	private String adresse1;
	private String adresse2;
	private String ville;
	private String pays;
	private String codePostal;
	

}
