package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
@Entity
public class Produit implements Serializable {
	
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private long id;

private String designation;

private double prix;
private int quantite;
public Produit() {
}
public Produit(String designation, double prix, int quantite) {	
	this.designation = designation;
	this.prix = prix;
	this.quantite = quantite;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
}
