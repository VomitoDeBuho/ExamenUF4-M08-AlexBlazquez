/**
 * Classe on transcurreix tot el joc i estableix les normes i mecàniques, necessita llibreries externes com poden ser l'arraylist i l'scanner entre altres.
 *
 * @author     Alex Blazquez Ruiz
 * @version    v0.2
 * 
 */
package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final Scanner sc = new Scanner(System.in);

    private ConfigGame config;
    private Menu menu;
    private Vehicle[] participants;
    List<ResultatsCursa> resultatsCursa = new ArrayList<>();
    ResultatsCursa resul = new ResultatsCursa();
    //definició de les puntuacions als primers 3 classificats
    private int[] puntuacions = {10,8,5};
    /**
     * Objecte Cursa on trovem el temps transcorrit per cada vehicle
     */
    class ResultatsCursa {
        double temps;
        Vehicle vehicle;
    }
	/**
     * Constructor principal i únic de la classe Game, realitza la configuració per defecte i obre el menú per l'interacció de l'usuari
     * @param
     */
    public Game() {
        config = new ConfigGame();
        menu = new Menu(this,config);
    }
    /**
     * Funció que inicia dintre de l'objecte menú la funció menuPrincipal
     * @param
     */
    public void start() {
        menu.menuPrincipal();
    }

    
    /** 
     * Printa la configuració de la partida, amb els valors per defecte, permet modificar aquest, crea els participants, i el nº de pilots
     * per calcular quin serà el temps de cadascún, utilitza un random per simular quant ha trigat un vehicle, fa un recorregut per tots els circuits
     * ordena la classificació, dona els punts i al final printa el guanyador.
     * Utilitza els atributs d'aquesta classe ANSI... per establir colors, com el groc per saber el circuit i el blau per saber quin jugador seràs
     * @param tipus
     * @todo refactoritzar i modular el mètode play
     */
    public void play(int tipus)  {
        System.out.println(config);

        //crear participant usuari i resta de participants
        participants = new Vehicle[config.getNumRunners()];
        addParticipants(tipus);

        //comença la cursa
        System.out.println("Pilots a la graella de sortida...");
        for(int i=0; i<participants.length; i++) {
            System.out.printf("%s ",participants[i].getPilot().getNom());
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
        //Recorregut per tots els circuits
        for(int i=0; i<config.getNumTracks(); i++) {
            System.out.println("Prem un tecla per iniciar el circuit " + i);
            sc.nextLine();
            System.out.println(ANSI_YELLOW + "Circuit " + i + ANSI_RESET);
            //simulació del temps que ha fet cada vehicle
            for (int t = 0; t < config.getNumRunners(); t++) {
                resultatsCursa.get(t).temps = (Math.random() * 10000 + 3000);
            }

            //ordenar classificació
            resultatsCursa.sort((o1, o2) -> (int) (o1.temps - o2.temps));
            //donar punts
            for(int p=0; p < resultatsCursa.size() && p<3; p++) {
                resultatsCursa.get(p).vehicle.getPilot().addPunts(puntuacions[p]);
                double t = resultatsCursa.get(p).temps;
                String nom = resultatsCursa.get(p).vehicle.getPilot().getNom();
                if(resultatsCursa.get(p).vehicle.getPilot().getNom().equals(config.getUserName())) System.out.printf(ANSI_BLUE);
                System.out.printf("%s %.2f +%d\n",nom,t,puntuacions[p]);
                System.out.printf(ANSI_RESET);
            }
            System.out.println("----------------------");
        }

    }

    
    /** 
     * Afageix participants a la cursa, el 1r portarà una bicicleta, el segon portarà un cotxe amb les velocitats proporcionades, en cas de posar 3 o 4, la opció no serà implementada
     * @param tipus
     * @todo refactoritzar el codi repetit
     */
    private void addParticipants(int tipus) {

        switch (tipus) {
            case 1:
                participants[0] = new Bicicleta(60);
                setParticipants();
                break;
            case 2:
                participants[0] = new Cotxe(300);
                setParticipants();
                break;
            case 3:
                System.out.println("Aquesta opció no està implementada");
                break;
            case 4:
                System.out.println("Aquesta opció no està implementada");
                break;
        }
    }
    /** 
     * Funció per ordenar i printar els resultats de manera colorida
     * @param tipus
     * @todo refactoritzar el codi repetit
     */
    public void finalResults() {
        resultatsCursa.sort((o1, o2) -> (int) (o2.vehicle.getPilot().getPunts() - o1.vehicle.getPilot().getPunts()));
        for(int i = 0; i < resultatsCursa.size(); i++) {
            ResultatsCursa r = resultatsCursa.get(i);
            if(r.vehicle.getPilot().getNom().equals(config.getUserName())) System.out.printf(ANSI_BLUE);
            System.out.printf("| %s\t| %d\t |\n",r.vehicle.getPilot().getNom(),r.vehicle.getPilot().getPunts());
            System.out.printf(ANSI_RESET);
        }
        System.out.println();
    }

    /** 
     * Funció per netejar els resultats de la cursa
     * @param tipus
     * @todo refactoritzar el codi repetit
     */
    public void initResults() {
        resultatsCursa.clear();
    }

    /** 
     * Funció per establir els participants amb els seus resultats
     * @param tipus
     * @todo refactoritzar el codi repetit
     */
    private void setParticipants() {
        participants[0].setPilot(new Pilot(config.getUserName()));
        resul.vehicle = participants[0];
        resultatsCursa.add(resul);
        for(int i=1; i<config.getNumRunners(); i++) {
            participants[i] = new Bicicleta(60);
            participants[i].setPilot(new Pilot("player-" + i));
            resul = new ResultatsCursa();
            resul.vehicle = participants[i];
            resultatsCursa.add(resul);
        }
    }

    private void eliminarDarrerClassificat() {
      //pendent  
    }


}
