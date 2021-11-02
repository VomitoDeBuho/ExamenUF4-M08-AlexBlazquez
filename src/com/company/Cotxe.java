/**
 * Classe de l'objecte Cotxe, hereta de la classe vehicle, amb un constructor i 2 atributs
 *
 * @author     Alex Blazquez Ruiz
 * @version    v0.2
 * 
 */
package com.company;
public class Cotxe extends Vehicle {
	private String Marca;
	private String Model;
    
	/**
     * Constructor principal i únic de la classe Cotxe, demana un Int que crida al constructor pare de la classe Vehicle, per establir la velocitat
     * @param vel
     */
	public Cotxe(int vel) {
		super(vel);
	}

	
	/** 
	 * Funció que ens retorna l'atribut string marca del cotxe
	 * @return String
	 */
	public String getMarca() {
		return Marca;
	}

	
	/** 
	 * Funció per poder establir o modificar la marca del cotxe
	 * @param marca
	 */
	public void setMarca(String marca) {
		Marca = marca;
	}

	
	/** 
	 * Funció que ens retorna l'atribut string Model del cotxe
	 * @return String
	 */
	public String getModel() {
		return Model;
	}

	
	/** 
	 * Funció per poder establir o modificar el model del cotxe
	 * @param model
	 */
	public void setModel(String model) {
		Model = model;
	}



}
