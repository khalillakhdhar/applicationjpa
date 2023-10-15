package com.relations.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(nullable = false)
private String nom,prenom;
@Min(value = 600)
@Column(nullable = false)
private double salaire;
@Transient
private double nette=0;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public double getSalaire() {
	return salaire;
}
public void setSalaire(double salaire) {
	this.salaire = salaire;
	this.setNette();
}
public double getNette() {
	this.setNette();
	return nette;
}
public void setNette() {
this.nette = this.salaire-calculeTva();
}
public double calculeTva()
{
if(this.salaire<1000)
	return salaire*0.07;
else if(this.salaire<1500)
	return salaire*0.1;
else
	return salaire*0.15;
}




public Employee(long id, String nom, String prenom, double salaire) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.salaire = salaire;
	this.nette = this.salaire-calculeTva();
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Employee [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + ", nette=" + getNette()
			+ ", calculeTva()=" + calculeTva() + "]";
}




}
