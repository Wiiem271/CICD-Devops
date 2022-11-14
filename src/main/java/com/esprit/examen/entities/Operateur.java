package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
public class Operateur implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperateur;
	private String nom;
	private String prenom;
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Facture> factures;

	public Operateur() {
	}

	public Operateur(String nom, String prenom, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password=password;
	}
	
}
