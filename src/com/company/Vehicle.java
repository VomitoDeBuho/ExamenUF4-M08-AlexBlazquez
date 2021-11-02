/**
 * Classe abstracta on deriven tots els vehicles, on s'estableix un pilot i una velocitat màxima
 *
 * @author     Alex Blazquez Ruiz
 * @version    v0.2
 * 
 */
package com.company;
public abstract class Vehicle {
	private int velocitatMAX;
	private Pilot pilot;

	/**
	 * Constructor Principal de la classe vehicle, donat per paràmtre una velocitat
	 * @param vel
	 */
	public Vehicle(int vel) {
		velocitatMAX = vel;
	}

	
	/** 
	 * Constructor en desús per el tipus de variable
	 * @param vel, tipus
	 * @deprecated 
	 */
	public Vehicle(int vel, int tipus) {
		velocitatMAX = vel;
	}

	/**
	 * Getter de la classe vehicle per obtenir el pilot
	 * @return pilot
	 */
	public Pilot getPilot() {
		return pilot;
	}

	
	/** 
	 * Setter de la classe vehicle per modificar o establir un pilot
	 * @param pilot
	 */
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	
	/** 
	 * Getter de la classe vehicle per obtenir un int de la velocitat màxima
	 * @return int
	 */
	public int getVelocitatMAX() {
		return velocitatMAX;
	}

	
	/** 
	 * Setter de la classe vehicle per modificar o establir la velocitat de l'objecte vehicle
	 * @param velocitatMAX
	 */
	public void setVelocitatMAX(int velocitatMAX) {
		this.velocitatMAX = velocitatMAX;
	}
}
