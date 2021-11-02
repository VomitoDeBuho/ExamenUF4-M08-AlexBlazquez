/**
 * Classe de l'objecte configGame on trovarem el tipus de configuració que vulgui l'usuari, consultar la configuració o establir-la
 *
 * @author     Alex Blazquez Ruiz
 * @version    v0.2
 * 
 */
package com.company;
public class ConfigGame {
    private String username;
    private int numRunners;
    private int numTracks;

    
    /** 
     * Funció per obtenir l'atrbut int del numero de pistes
     * @return int
     */
    public int getNumTracks() {
        return numTracks;
    }

    
    /** 
     * Funció per posar el numero de pistes que l'usuari dessitgi
     * @param numTracks
     */
    public void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
    }


    /** 
     * Constructor principal de la classe, s'establirant uns valors per defecte sense que l'usuari hagi d'establir res
     * @param 
     */
    public ConfigGame() {
        numRunners = 5;
        numTracks = 3;
        username = "player";
    }

    
    /** 
     * Funció per posar el nom d'usuari que dessitgi
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /** 
     * Funció per obtenir l'atribut usuername
     * @return String
     */
    public String getUserName() {
        return username;
    }

    
    /** 
     * Funció per obtenir el nombre de participants
     * @return int
     */
    public int getNumRunners() {
        return numRunners;
    }

    
    /** 
     * Funció per establir el nombre de participants que estableixi l'usuari
     * @param numRunners
     */
    public void setNumRunners(int numRunners) {
        this.numRunners = numRunners;
    }

    
    /** 
     * Funció sobrecarregada per retornar en una string tots els atributs de la classe ConfigGame
     * @return String
     */
    public String toString() {
        return "ConfigGame{" +
                "username='" + username + '\'' +
                ", numRunners=" + numRunners +
                ", numTracks=" + numTracks +
                '}';
    }
}
