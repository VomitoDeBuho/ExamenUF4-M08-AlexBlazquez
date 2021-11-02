/**
 * Classe de l'objecte Pilot, amb 3 atributs --> nom, nivell i punts, amb un constructor
 *
 * @author     Alex Blazquez Ruiz
 * @version    v0.2
 * 
 */
package com.company;
import java.util.Date;

public class Pilot {
	private String nom;
	private int nivell;
	private int punts;

	/**
	 * Constructor de l'objecte Pilot, només hi ha un sol parametre
	 * @param nom
	 * 
	 */
	public Pilot(String nom) {
		this.nom = nom;
	}

	/**
	 * Constructor secundari només passant-li una sola string
	 */
	//ara tractem els punts de forma diferent
	//public Pilot(String punts) {
	//	this.punts = punts;
	//}
	
	/**
	 * Getter de la classe pilot per obtenir el nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	
	/** 
	 * Getter de la classe pilot per obtenir els punts
	 * @return int
	 */
	public int getPunts() {
		return punts;
	}

	
	/** 
	 * Funció per poder modificar els punts o establir-los dins la classe pilot
	 * @param punts
	 */
	public void setPunts(int punts) {
		this.punts = punts;
	}

	
	/** 
	 * Funció per poder afegir punts dins la classe pilot
	 * @param p
	 */
	public void addPunts(int p) {
		punts += p;
	}

	
	/** 
	 * Funció sobrecarregada per retornar en una string tots els atributs de la classe Pilot
	 * @return String
	 */
	//sobrecàrrega que hereta de la classe Object
	public String toString() {
		return "Pilot{" +
				"nom='" + nom + '\'' +
				", punts=" + punts +
				'}';
	}
}
