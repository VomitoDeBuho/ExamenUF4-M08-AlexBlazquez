/**
 * Classe de l'objecte Bicicleta que hereta de Vehicle, amb un sol constructor sense cap atribut
 *
 * @author     Alex Blazquez Ruiz
 * @version    v0.2
 * 
 */
package com.company;
public class Bicicleta extends Vehicle{
    /**
     * Constructor principal i únic de la classe bicicleta, demana un Int que crida al constructor pare de la classe Vehicle, per establir la velocitat
     * @param vel
     */
    public Bicicleta(int vel) {
        super(vel);
    }

    //variable "tipus" en desús
    /**
     * Constructor principal i únic de la classe bicicleta, demana un Int que crida al constructor pare de la classe Vehicle, en desùs per que no s'utilitza el tipus
     * @param vel
     * @deprecated tipus
     */
    public Bicicleta(int vel, int tipus) {
        super(vel);
    }
}
