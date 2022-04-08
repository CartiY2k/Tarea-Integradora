package ui;

import model.*;
import java.util.Scanner;

/**
 * @author Juan David Patiño
 */

public class Main {
    public static  Scanner lc = new Scanner(System.in);
    public static Municipality municipality = new Municipality("Santiago de cali");


    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int decition =-1;
        while(decition!=9){
         decition = menu();
            switch (decition){
                case 1:
                    registerWetland();
                    break;
                case 2:
                    registerEvent();
                    break;
                case 3:
                    registerSpecies();
                    break;
                case 4:
                    howManyMaintenances();
                    break;
                case 5:
                    fewestSpecies();
                    break;
                case 6:
                    highestSpecies();
                    break;
                case 7:
                    searchSpecies();
                    break;
                case 8:
                    wetlandsAndSpecies();
                    break;
                default:
                    break;

            }
        }
    }
    //Methods
    /**
     * <b> pre:<b>
     * <b> pos:<b>
     * @return the option tha te user wanna do
     */

    public static int menu() {
        System.out.println("///////Menu///////");
        System.out.println("[1]Register a Wetland.");
        System.out.println("[2]Register an Event.");
        System.out.println("[3]Register a species.");
        System.out.println("[4]The Wetland information(maintenance).");
        System.out.println("[5]The Wetland with less flora.");
        System.out.println("[6]The Wetland with the greatest fauna.");
        System.out.println("[7]Search a species.");
        System.out.println("[8]All Wetlands with its Species.");
        System.out.println("[9]Exit");
        int asnwer =lc.nextInt() ;
        lc.nextLine();
        return asnwer;

    }
    /**
     * <b> pre:<b>
     * <b> pos:<b> 
     * @return
     */

    //Option 1 

    public static void registerWetland() {
        System.out.println("Wetland's name:");
        String name = lc.nextLine();
        System.out.println("Wetland's Zone [1]Urban | [2]Rural");
        int zoneType = lc.nextInt();
        lc.nextLine();
        String whereZone = "";
        if(zoneType == 1){
            System.out.println("Gimme the wetland's Neighborhood");
            whereZone= lc.nextLine();
        }else{
            System.out.println("Gimme the wetland's village");
            whereZone = lc.nextLine();
        }
        System.out.println("Wetland's privacity [1]Public | [2]Private");
        int  privacityType = lc.nextInt();
        lc.nextLine();
        System.out.println("Quantity Km2:");
        String quantityKm2 = lc.nextLine();
        System.out.println("Url image:");
        String url = lc.nextLine();
        System.out.println("It's a protected Area [1.Yes/2.No]");
        String protectedArea = lc.nextLine();
        System.out.println("Gimme the average of the Enviroment Test");
        String enviromentTest = lc.nextLine();
        String message = municipality.addWetland(name, zoneType, privacityType, quantityKm2, url, protectedArea, enviromentTest);
        System.out.println(message);
    }
    /**
     * <b> pre:<b>
     * <b> pos:<b> 
     * @return
     */

    //Option 2 
    public static void registerEvent(){
        System.out.println("////Event////");
        System.out.println("In what wetland do you wanna register the event?");
        String nameSearch = lc.nextLine();
        int answer = municipality.searchWetland(nameSearch);
        if(answer>-1){
            System.out.println("Select One:");
            System.out.println("[1] Maintenance. [2] School Visit. [3] Improvement Activity. [4] Celebration.");
            int eventType = lc.nextInt();
            lc.nextLine();
            System.out.println("Put the day:");
            int day = lc.nextInt();
            lc.nextLine();
            System.out.println("Put the month:");
            int month = lc.nextInt();
            lc.nextLine();
            System.out.println("Put the year:");
            int year = lc.nextInt();
            lc.nextLine();
            System.out.println("Who's the event director?");
            String directorName = lc.nextLine();
            System.out.println("How much does the event cost?");
            double value = lc.nextDouble();
            lc.nextLine();
            System.out.println("Description:");
            String description = lc.nextLine();
            String message = municipality.addEvent(eventType,directorName,value,description,day,month, year,answer);
            System.out.println(message);


        }else
            System.out.println("The wetland "+ nameSearch+" haven't registered yet.");
        
    }
    /**
     * <b> pre:<b>
     * <b> pos:<b> 
     * @return
     */

    //Option 3
    public static void registerSpecies(){
        System.out.println("//////////FAUNA AND FLORA//////////");
        System.out.println("In what wetland do you wanna register the New Fauna or Flora?");
        String nameSearch = lc.nextLine();
        int answer = municipality.searchWetland(nameSearch);
        if(answer > -1){
            System.out.println(nameSearch+" found.");
            System.out.println("Put the specie Name:");
            String name = lc.nextLine();
            System.out.println("Put the Scientific Name:");
            String scientificName = lc.nextLine();
            System.out.println("¿Is it a migratory Specie?[Yes]/[No]");
            String migratorySpecie = lc.nextLine();
            System.out.println("Select One Specie type:");
            System.out.println("[1]Terrestic flora. [2]Acuatic flora. [3]Bird. [4]Mammal. [5]Aquatic animal.");
            int speciType = lc.nextInt();
            lc.nextLine();
            String message = municipality.addSpecies(name,scientificName,migratorySpecie,speciType,answer);
            System.out.println(message);
        }else
            System.out.println("The wetland "+ nameSearch+" haven't registred yet.");
    }

    /**
     * <b> pre:<b>
     * <b> pos:<b> 
     * @return
     */
    //Option 4
    public static void howManyMaintenances(){
        System.out.println("////////Information///////");
        int counterHowMany = municipality.counterExistWetland();
        if(counterHowMany > 0){
            System.out.print("What's the year that you wanna know?");
            int yearSerch = lc.nextInt();
            lc.nextLine();
            for (int i = 0; i <counterHowMany; i++) {
                String message = municipality.countMaintenance(i,yearSerch);
                System.out.println(message);
            }
            
        }else
            System.out.println("You haven't registered any wetlands yet.");
    }

    /**
     * <b> pre:<b>
     * <b> pos:<b> 
     * @return
     */
    //Option 5
    public static void fewestSpecies() {
        String message = municipality.counterSpecies();
        System.out.println("///////// The fewest /////////////");
        System.out.println(message);
    }

    /**
     * <b> pre:<b>
     * <b> pos:<b>
     * @return
     */


    //Option 6 
    public static void highestSpecies() {
        String message = municipality.counterSpeciesHighest();
        System.out.println("///////// The highest /////////////");
        System.out.println(message);
    }

    /**
     * <b> pre:<b>
     * <b> pos:<b> 
     * @return
     */

    
    //Option 7
    public static void searchSpecies(){
        System.out.println("/////Search Specie/////");
        System.out.println("What's the Specie?");
        String nameSpecies = lc.nextLine();
        String[] wetlandsSpeciesNames = municipality.serchSpecies(nameSpecies);
        int truecounter = 0;
        for(int i = 0;i<wetlandsSpeciesNames.length &&wetlandsSpeciesNames[i]!= null;i++)
            if(wetlandsSpeciesNames[i].equalsIgnoreCase("-1")){
            }
            else {
                truecounter++;
                System.out.println("["+truecounter+"]"+wetlandsSpeciesNames[i]);
            }
        
        if(wetlandsSpeciesNames[0]== null)
            System.out.println("Any wetland have "+ nameSpecies+" as a specie.");

    }


    /**
     * <b> pre:<b>
     * <b> pos:<b>
     * @return
     */

    //Option 8
    public static void wetlandsAndSpecies(){
        System.out.println("//////Species in the Wetlands/////");
        int howmany = municipality.howManyWetlands();
        for(int i = 0; i<howmany&& howmany != 0;i++)
            System.out.println("["+(i+1)+"] "+municipality.showWetlands(i));
        if(howmany == 0)
            System.out.println("You haven't registered any wetlands yet.");

        

    }



}