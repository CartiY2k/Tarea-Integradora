package model;
public class Municipality {
    // Constant
    public static final int WETLANDNUMBER = 80;
    // Atriubutos
    private String name;
    // Relaciones
    private Wetland[] wetlands;

    // Methods & Constructor.
    public Municipality(String name) {
        this.name = name;
        wetlands = new Wetland[WETLANDNUMBER];
    }

    /**
     * 
     * @param nameSpecie
     * @return
     */
    public String[] serchSpecies(String nameSpecie){
        boolean exitOrNo = false;
        String[] wetlandsSpeciesNames = new String[WETLANDNUMBER];
        for(int i=0 ;i<wetlandsSpeciesNames.length && wetlands[i] != null;i++){
            exitOrNo = wetlands[i].searchSpecie(nameSpecie);
            if(exitOrNo == true)
                wetlandsSpeciesNames[i] = wetlands[i].getName();
            else
                wetlandsSpeciesNames[i] = "-1";

            
        }
        return wetlandsSpeciesNames;
    }



   

    /**
     * 
     * @return
     */
    public String counterSpecies(){
        int fewest = 1000000000;
        String fewestName ="";
        boolean wetlandDontHaveName = true;
        String message ="";
        for(int i = 0;i<wetlands.length && wetlands[i] != null;i++){
            if(fewest > wetlands[i].counterFlora()){
                fewest = wetlands[i].counterFlora();
                fewestName = wetlands[i].getName();
                wetlandDontHaveName = false;
            }
        }
        if(wetlandDontHaveName)
            message = "you haven't registered any wetland yet.";
        else 
            message = fewestName+" is the wetland with less flora "+ fewest;
        
        return message;
    }

    /**
     * 
     * @return
     */

    public String counterSpeciesHighest(){
        int highest = 0;
        String highestName ="";
        boolean wetlandDontHaveName = true;
        String message ="";
        if(wetlands[0] != null){
            highestName =wetlands[0].getName();
        }
        for(int i = 0;i<wetlands.length && wetlands[i] != null;i++){
            wetlandDontHaveName = false;
            if(highest < wetlands[i].counterFauna()){
                highest = wetlands[i].counterFauna();
                highestName = wetlands[i].getName();
            }
        }
        if(wetlandDontHaveName)
            message = "you haven't registered any wetland yet.";
        
        else 
            message = highestName+" is the wetland with highest fauna Species "+ highest;

        
        return message;
    }
    /**
     * 
     * @param eventType
     * @param directorName
     * @param value
     * @param description
     * @param day
     * @param month
     * @param year
     * @param positionWetland
     * @return
     */

    public String addEvent( int eventType,String directorName,double value,String description,int day,int month, int year,int positionWetland){
        String message = wetlands[positionWetland].registerdEvent(eventType,directorName,value,description,day,month, year);
        return message;
    }
    /**
     * 
     * @param wetlandPosition
     * @param yearSerch
     * @return
     */

    public String countMaintenance(int wetlandPosition,int yearSerch){
        String message = wetlands[wetlandPosition].gimmeTheInformatiton(wetlandPosition,yearSerch);
        return message;
    }

    /**
     * 
     * @param name
     * @param zone
     * @param type
     * @param quantityKm2
     * @param url
     * @param proctedArea
     * @param enviromentTest
     * @return
     */

    public String addWetland(String name, int zoneType, int privacityType, String quantityKm2, String url, String proctedArea,String enviromentTest){
        int haveTheSameName = diferentName(name);
        String message = "Registred Wetland";
        if(haveTheSameName==0){
            boolean continue1 = true;
            for (int i = 0; i < wetlands.length && continue1 != false; i++){
                if (wetlands[i] == null) {
                    wetlands[i] = new Wetland(name, zoneType, privacityType, quantityKm2, url, proctedArea, enviromentTest);
                    continue1 = false;
                }
            }
            if (continue1 == true) {
                message = "Overly wetlands";
            }
        }else{
            message = "Sorry, the wetland "+ name+ " has registered.";
        }
        return message;
    }
    /**
     * 
     * @param name
     * @return
     */

    public int diferentName(String name){
        int haveTheSameName = 0;
        boolean continuar1 = true;
        for(int i = 0;i<wetlands.length && continuar1 != false &&wetlands[i]!=null;i++){
            if(wetlands[i].getName().equalsIgnoreCase(name)){
                haveTheSameName = 1;
                continuar1 = false;
            }
        }
        return haveTheSameName;
    }
    /**
     * 
     * @param name
     * @param scientificName
     * @param migratorySpecie
     * @param speciType
     * @param positionWetland
     * @return
     */

    public String addSpecies(String name, String scientificName,String migratorySpecie ,int speciType,int positionWetland){
        String message = wetlands[positionWetland].registerSpecie(name,scientificName,migratorySpecie,speciType);
        return message;

    }

    public int howManyWetlands(){
        int counter=0;
        for(int i = 0;wetlands[i]!= null;i++)
            counter++;
        
        return counter;
    }


    public String showWetlands(int positionWetland){
        String message = wetlands[positionWetland].getName()+" have "+(wetlands[positionWetland].counterFauna()+wetlands[positionWetland].counterFlora())+" Species.";
        return  message;
    }


    public int counterExistWetland(){
        int counterWetland = 0;
        for (int i = 0; i < wetlands.length && wetlands[i]!= null; i++) 
            counterWetland++;

        return counterWetland;        
    }

    /**
     * 
     * @param wetlandSearch
     * @return
     */

    public int searchWetland(String wetlandSearch){
        int position = -1;
        boolean continue1 = true;
       for(int i = 0;i<wetlands.length&& continue1 != false&& wetlands[i]!= null;i++){
            if(wetlands[i].getName().equalsIgnoreCase(wetlandSearch)){
                position = i;
                continue1 = false;
            }
       }
        return position;
    }
}
