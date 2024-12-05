package com.in28minutes.rest.webservices.restful_web_services.User;

import java.time.LocalDate;

public class User {
	
	private Integer id;
	private String nom;
	private LocalDate dateNaissance;
	
	public User(Integer id, String nom, LocalDate dateNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", dateNaissance=" + dateNaissance + "]";
	}

}
